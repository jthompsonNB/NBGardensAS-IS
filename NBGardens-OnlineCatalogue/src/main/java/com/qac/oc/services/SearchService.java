package com.qac.oc.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.oc.entities.Product;
import com.qac.oc.managers.ProductManager;
import com.qac.oc.util.ProductItem;

@Stateless
public class SearchService {
	@Inject
	private ProductManager productRepository;
	@Inject
	private ProductService productService;
	
	@Deprecated
	public List<Product> findByKeyword(String term) {
		List<Product> results = new ArrayList<>();
		results.addAll(searchByProductName(term));
		for(Product product : searchByProductDescription(term))
			if(!results.contains(product))
				results.add(product);
		return results;
	}

	private List<Product> searchByProductName(String name) {
		return productRepository.findByNameLike(name);
	}
		
	private List<Product> searchByProductDescription(String description) {
		return productRepository.findByDescriptionLike(description);
	}

	public List<ProductItem> searchBy(String term) {
		List<Product> results = new ArrayList<>();
		if(term.matches("[0-9]")) {
			Product result = productService.findProductById(term);
			if(result != null)
				results.add(result);
		}		
		results.addAll(searchByProductName(term));
		results.addAll(searchByProductDescription(term));
		if(results.isEmpty())
			return null;
		List<ProductItem> productItems = new ArrayList<>();
		results.forEach(product->{
			productItems.add(productService.getProductItem(product, product.getId()));
		});
		return productItems;
	}
}