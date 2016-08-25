package com.qac.oc.repositories.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import com.qac.oc.entities.Product;
import com.qac.oc.repositories.ProductRepository;
import com.qac.oc.util.Mongo;

@Stateless
@Default
@Mongo
public class ProducttRepositoryOfflineMongo implements ProductRepository {

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
