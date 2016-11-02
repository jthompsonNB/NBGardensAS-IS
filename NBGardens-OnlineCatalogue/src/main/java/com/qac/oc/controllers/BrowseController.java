package com.qac.oc.controllers;

import javax.enterprise.context.ConversationScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.oc.entities.mongo.Product;
import com.qac.oc.services.ProductService;
import com.qac.oc.util.PaginationHelper;

@Named("browse")
@ConversationScoped
public class BrowseController {
	@Inject
	private ProductService productService;
	private PaginationHelper pagenationHelper;
	private DataModel<Product> dataModel = null;
	
	public PaginationHelper getPagination() {
		if (pagenationHelper == null) {
			pagenationHelper = new PaginationHelper(9) {
				
				@Override
				public int getItemsCount() {
					return productService.findAll().size();
				}
				
				@Override
				public DataModel<Product> createPageDataModel() {
					try {
						return new ListDataModel<Product>(productService.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(productService.findAll().subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};
		}
		return pagenationHelper;
	}

	private void recreateModel() {
		dataModel = null;
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
	
	public DataModel<Product> getDataModel() {
		return (DataModel<Product>) getPagination().createPageDataModel();
	}
}