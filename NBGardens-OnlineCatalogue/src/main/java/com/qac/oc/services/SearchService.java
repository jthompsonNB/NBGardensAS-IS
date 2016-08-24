package com.qac.oc.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.oc.entities.Product;
import com.qac.oc.repositories.ProductRepository;

@Stateless
public class SearchService {
	@Inject
	private ProductRepository productRepository;
	
	public List<Product> findByKeyword(String term) {
		List<Product> results = new ArrayList<>();
		results.addAll(searchByProductName(term));
		for(Product product : searchByProductDescription(term))
			if(!results.contains(product))
				results.add(product);
		for(Product product : searchByProductCatagory(term))
			if(!results.contains(product))
				results.add(product);
		return results;
	}

	private List<Product> searchByProductName(String name) {
		return productRepository.findByNameLike(name);
	}
	
	private List<Product> searchByProductDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<Product> searchByProductCatagory(String catagory) {
		// TODO Auto-generated method stub
		return null;
	}
}