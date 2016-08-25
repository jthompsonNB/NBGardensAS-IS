package com.qac.oc.repositories;

import java.util.List;

import com.qac.oc.entities.Product;

public interface ProductRepository {
	public List<Product> findAll();
	public Product findById(long longValue);
	public List<Product> findByNameLike(String name);
	public List<Product> findByDescriptionLike(String description);
}