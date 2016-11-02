package com.qac.oc.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.oc.entities.mongo.Product;
import com.qac.oc.managers.ProductMarager;
import com.qac.oc.util.ProductItem;

@Stateless
public class ProductService {
	@Inject
	private ProductMarager productRepository;

	public Product findProductById(String id) {
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

	public ProductItem getProductItem(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}