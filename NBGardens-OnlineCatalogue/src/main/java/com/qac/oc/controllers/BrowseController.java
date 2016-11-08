package com.qac.oc.controllers;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.oc.entities.Product;
import com.qac.oc.services.ProductService;
import com.qac.oc.util.PaginationHelper;
import com.qac.oc.util.ProductItem;

@Named("browse")
@ConversationScoped
public class BrowseController implements Serializable {
	@Inject
	private ProductService productService;
	private PaginationHelper pagenationHelper;
	private DataModel<ProductItem> products = null;
	
	public PaginationHelper getPagination() {
		if (pagenationHelper == null) {
			pagenationHelper = new PaginationHelper(9) {
				
				@Override
				public int getItemsCount() {
					return productService.findAllActive().size();
				}
				
				@Override
				public DataModel<ProductItem> createPageDataModel() {
					try {
						return new ListDataModel<ProductItem>(productService.findAllActive().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<ProductItem>(productService.findAllActive().subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};
		}
		return pagenationHelper;
	}

	private void recreateModel() {
		products = null;
	}
	
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "browse";
	}
	
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "browse";
	}
	
	public DataModel<ProductItem> getProducts() {
		return (DataModel<ProductItem>) getPagination().createPageDataModel();
	}
}