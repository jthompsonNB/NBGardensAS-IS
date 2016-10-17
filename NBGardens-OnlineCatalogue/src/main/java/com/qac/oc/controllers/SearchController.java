package com.qac.oc.controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.oc.services.ProductService;

//@Path("/search")
@Named("search")
@RequestScoped
public class SearchController {
	@Inject
	private ProductService productService;
	@Inject 
	private SelectedProduct selectedProduct;
	private String term;
	
	public String search(){
		System.out.println(">>> Searching for " + term);
		try {
			selectedProduct.setProduct(productService.findProductById(term));
			System.out.println(">>> Worked!");
			return "details";
		} catch (Exception e) {
			System.out.println(">>> woops!");
			return "browse";
		}
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
}
//	@Inject
//	private SearchService searchService;
//	
//	@GET
//	@Path("/{term}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Product> search(@PathParam("term") String term) {
//		return searchService.findByKeyword(term);
//	}
//}
//	
//}