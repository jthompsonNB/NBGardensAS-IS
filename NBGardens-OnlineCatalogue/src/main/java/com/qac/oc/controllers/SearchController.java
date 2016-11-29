package com.qac.oc.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.oc.controllers.session.SelectedProduct;
import com.qac.oc.services.SearchService;
import com.qac.oc.util.ProductItem;

/**
 * This controller handles the searching of products on the Online Catalogue.
 * 
 * @author James Thompson
 *
 */
@Named("search")
@RequestScoped
public class SearchController {
	@Inject
	private SearchService searchService;
	@Inject 
	private SelectedProduct selectedProduct;
	@Inject
	private SearchResultsController searchResults;
	private String term;
	
	/**
	 * Handles the searching of the catalogue using the term set via setTerm()
	 * 
	 * @return returns searchResults for the list of results or product if a single product was found. returns browse if none were found
	 */
	public String search(){
		List<ProductItem> results = searchService.searchBy(term);
		if (results != null)
			if (results.size() == 1) {
				selectedProduct.setProduct(results.get(0));
				return "product";
			} else {
				searchResults.setResults(results);
				return "searchResults";
			}
		return "browse";
	}

	public String getTerm() { return term; }
	public void setTerm(String term) { this.term = term; }
}