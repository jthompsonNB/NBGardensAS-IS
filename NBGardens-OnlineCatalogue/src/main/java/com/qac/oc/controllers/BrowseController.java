package com.qac.oc.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.oc.entities.mongo.Product;
import com.qac.oc.services.ProductService;
import com.qac.oc.util.PagenationHelper;

@Named("products")
@SessionScoped
public class BrowseController implements Serializable {
	private static final long serialVersionUID = -1995906091201060046L;
	@Inject
	private ProductService productService;
	@Inject
	private SelectedProduct product;
	private PagenationHelper pagenationHelper;
	@SuppressWarnings("unused")
	private int selectedItemIndex;
	@SuppressWarnings("unused")
	private DataModel<Product> dataModel = null;
	
	public PagenationHelper getPagination() {
		if (pagenationHelper == null) {
			pagenationHelper = new PagenationHelper(9) {
				
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
	
	@SuppressWarnings("unchecked")
	public DataModel<Product> getDataModel() {
		return (DataModel<Product>) getPagination().createPageDataModel();
	}
}