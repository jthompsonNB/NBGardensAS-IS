package com.qac.oc.repositories.mongo;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.qac.oc.entities.mongo.Product;
import com.qac.oc.repositories.ProductRepository;

@Stateless
@Alternative
public class ProductRepositoryMongo implements ProductRepository {
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Product findById(long longValue) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Product> findByNameLike(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Product> findByDescriptionLike(String description) {
		// TODO Auto-generated method stub
		return null;
	}
}