package com.qac.oc.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.oc.entities.mongo.Product;
import com.qac.oc.managers.ProductMarager;
import com.qac.oc.util.ProductItem;

@Stateless
public class SearchService {
	@Inject
	private ProductMarager productRepository;
	
	public List<Product> findByKeyword(String term) {
		List<Product> results = new ArrayList<>();
		results.addAll(searchByProductName(term));
		for(Product product : searchByProductDescription(term))
			if(!results.contains(product))
				results.add(product);
//		for(Product product : searchByProductCatagory(term))
//			if(!results.contains(product))
//				results.add(product);
		return results;
	}

	private List<Product> searchByProductName(String name) {
		return productRepository.findByNameLike(name);
	}
	
	
	private List<Product> searchByProductDescription(String description) {
		return productRepository.findByDescriptionLike(description);
	}

	public List<ProductItem> searchBy(String term) {
		// TODO Auto-generated method stub
		return null;
	}
}