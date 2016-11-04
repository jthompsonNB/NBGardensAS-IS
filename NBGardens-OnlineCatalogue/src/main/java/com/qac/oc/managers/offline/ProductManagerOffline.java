package com.qac.oc.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.oc.entities.mongo.Product;
import com.qac.oc.managers.ProductManager;
import com.qac.oc.util.TestData;

@Stateless
@Default
public class ProductManagerOffline implements ProductManager {
	@Inject
	private TestData testData;
	
	@Override
	public List<Product> findAll() {
		return testData.getProducts();
	}

	@Override
	public Product findById(long productId) {
		for(Product product : testData.getProducts())
			if(product.getId() == productId)
				return product;
		return null;
	}

	@Override
	public List<Product> findByNameLike(String name) {
		List<Product> products = new ArrayList<>();
		for(Product product : testData.getProducts())
			if (product.getName().toLowerCase().contains(name.toLowerCase()))
				products.add(product);
		return products;
	}

	@Override 
	public List<Product> findByDescriptionLike(String description) {
		List<Product> products = new ArrayList<>();
		for(Product product : testData.getProducts())
			if (product.getDescription().toLowerCase().contains(description.toLowerCase()))
				products.add(product);
		return products;
	}
}