package com.qac.oc.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.oc.entities.Product;
import com.qac.oc.repositories.ProductRepository;

@Stateless
public class ProductService {
	@Inject
	private ProductRepository productRepository;

	public Product findProductById(String id) {
		Integer productId = Integer.parseInt(id);
		return findProductById(productId.longValue());
	}

	public Product findProductById(long id) {
		return productRepository.findById(id);
	}
}