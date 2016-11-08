package com.qac.oc.managers;

import java.util.List;
import java.util.logging.Logger;

import com.qac.oc.entities.Product;

public interface ProductManager {
	static Logger logger = Logger.getLogger("ProductReository");
	public List<Product> findAll();
	public Product findById(long longValue);
	public List<Product> findByNameLike(String name);
	public List<Product> findByDescriptionLike(String description);
}