package com.qac.oc.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.oc.entities.mongo.Product;
import com.qac.oc.repositories.ProductRepository;

@Stateless
public class ProductService {
	@Inject
	private ProductRepository productRepository;

	public Product findProductById(String id) {
		System.out.println(">>> ID:" + id);
		try {
			long longId = Long.parseLong(id);
			return findProductById(longId);
		} catch (Exception e) {
			return null;
		}
	}

	public Product findProductById(long id) {
		return productRepository.findById(id);
	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
}