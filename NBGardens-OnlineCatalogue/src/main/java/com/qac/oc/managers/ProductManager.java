package com.qac.oc.managers;

import java.util.List;
import java.util.logging.Logger;

import com.qac.oc.entities.Product;

/**
 * The entity manager for the product entity
 * 
 * @author James Thompson
 *
 */
public interface ProductManager {
	static Logger logger = Logger.getLogger("ProductReository");
	
	/**
	 * Returns all the products
	 * 
	 * @return
	 */
	public List<Product> findAll();
	
	/**
	 * Finds a specific product using the Id
	 * 
	 * @param longValue
	 * @return
	 */
	public Product findById(long longValue);
	
	/**
	 * Returns all the products with a name like the one given
	 * 
	 * @param name
	 * @return
	 */
	public List<Product> findByNameLike(String name);
	
	/**
	 * Returns all products with a description that is like or contains the provided description.
	 * 
	 * @param description
	 * @return
	 */
	public List<Product> findByDescriptionLike(String description);
}