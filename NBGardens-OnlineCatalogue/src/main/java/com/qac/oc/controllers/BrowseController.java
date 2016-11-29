package com.qac.oc.controllers;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.oc.services.ProductService;
import com.qac.oc.util.PaginationHelper;
import com.qac.oc.util.ProductItem;

/**
 * This Bean is used to display the catalogue to the user.
 * It also provides an implementation of a paginator so that the number of products served to the user at one time are limited in order to save on their bandwith.
 * 
 * @author James Thompson
 */
@Named("browse")
@ConversationScoped
public class BrowseController implements Serializable {
	private static final long serialVersionUID = 7787469800840772887L;
	@Inject
	private ProductService productService;
	private PaginationHelper pagenationHelper;
	private DataModel<ProductItem> products = null;
	
	/**
	 * This method creates the Pagination Helper should none exist and then returns it for use throughout the class.
	 * 
	 * @return
	 */
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

	/**
	 * Resets the DataModel to null in order for it to be re-populated
	 */
	private void recreateModel() {
		products = null;
	}
	
	/**
	 * Moves the Paginator to the next page of results
	 * 
	 * @return "browse", Loads the browse page.
	 */
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "browse";
	}

	/**
	 * Moves the Paginator to the previous page of results
	 * 
	 * @return "browse", Loads the browse page.
	 */
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "browse";
	}
	
	/**
	 * Instructs the Paginator to the fetch next page of results
	 * 
	 * @return The next set of results.
	 */
	@SuppressWarnings("unchecked")
	public DataModel<ProductItem> getProducts() {
		if (products == null)
			products = (DataModel<ProductItem>) getPagination().createPageDataModel();
		return products; 
	}
}