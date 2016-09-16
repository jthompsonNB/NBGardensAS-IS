package com.qac.oc.repositories.offline;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.oc.entities.Product;
import com.qac.oc.repositories.ProductRepository;
import com.qac.oc.util.TestData;

@Stateless
@Default
public class ProductRepositoryOffline implements ProductRepository {
	@Inject
	private TestData testData;
	
	@Override
	public List<Product> findAll() {
		return testData.getProducts();
	}

	@Override
	public Product findById(long longValue) {
		try {
			logger.log(Level.FINE, "ProductRepositoryOffline.findById: Searching for product" + longValue);
			return testData.getProducts().get(testData.getProducts().indexOf(new Product(longValue, null, 0, 0, null)));
		} catch (ArrayIndexOutOfBoundsException exception) {
			logger.log(Level.INFO, "ProductRepositoryOffline.findById: Searching for unknown product" + longValue);
			return null;
		}
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
	@Deprecated
	public List<Product> findByDescriptionLike(String description) {
		return testData.getProducts();
	}
}