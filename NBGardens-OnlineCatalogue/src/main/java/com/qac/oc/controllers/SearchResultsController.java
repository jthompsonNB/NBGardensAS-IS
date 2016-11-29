package com.qac.oc.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import com.qac.oc.util.PaginationHelper;
import com.qac.oc.util.ProductItem;

/**
 * This controller operates similarly to the browse controller but for the search results as opposed to the full catalogue
 * 
 * @author James Thompson
 *
 */
@Named("searchResults")
@SessionScoped
public class SearchResultsController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2173863615045324385L;
	private PaginationHelper pagination = null;
	private List<ProductItem> searchResults;
	private DataModel<ProductItem> results = null;
	
	/**
	 * This method creates the Pagination Helper should none exist and then returns it for use throughout the class.
	 * 
	 * @return
	 */
	public PaginationHelper getPagination() {
		if (pagination == null) {
			pagination = new PaginationHelper(9) {
				
				@Override
				public int getItemsCount() {
					return searchResults.size();
				}
				
				@Override
				public DataModel<ProductItem> createPageDataModel() {
					try {
						return new ListDataModel<ProductItem>(searchResults.subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<ProductItem>(searchResults.subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};
		}
		return pagination;
	}

	/**
	 * Resets the DataModel to null in order for it to be re-populated
	 */
	private void recreateModel() {
		results = null;
	}
	
	/**
	 * Moves the Paginator to the next page of results
	 * 
	 * @return "browse", Loads the browse page.
	 */
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "results";
	}
	
	/**
	 * Moves the Paginator to the previous page of results
	 * 
	 * @return "browse", Loads the browse page.
	 */
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "results";
	}
	
	/**
	 * Instructs the Paginator to the fetch next page of results
	 * 
	 * @return The next set of results.
	 */
	@SuppressWarnings("unchecked")
	public DataModel<ProductItem> getResults() {
		if (results == null)
			results = (DataModel<ProductItem>) getPagination().createPageDataModel();
		return results;
	}

	/**
	 * Used to set the set of products to paginate.
	 * 
	 * @param searchResults
	 */
	public void setResults(List<ProductItem> searchResults) {
		pagination = null;
		results = null;
		this.searchResults = searchResults;
	}
}