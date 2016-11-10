package com.qac.oc.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import com.qac.oc.util.PaginationHelper;
import com.qac.oc.util.ProductItem;

@Named("searchResults")
@SessionScoped
public class SearchResultsController implements Serializable {
	private PaginationHelper pagination = null;
	private List<ProductItem> searchResults;
	private DataModel<ProductItem> results = null;
	
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

	private void recreateModel() {
		results = null;
	}
	
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "results";
	}
	
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "results";
	}
	
	public DataModel<ProductItem> getResults() {
		return (DataModel<ProductItem>) getPagination().createPageDataModel();
	}

	public void setResults(List<ProductItem> searchResults) {
		pagination = null;
		results = null;
		this.searchResults = searchResults;
	}
}