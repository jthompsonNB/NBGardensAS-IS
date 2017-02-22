package com.qac.oc.managers.mongo;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.qac.oc.entities.Product;
import com.qac.oc.managers.ProductManager;

/**
 * This implementation is designed to pull products from MongoDB
 * 
 * @author James Thompson
 *
 */
@Stateless
@Alternative
public class ProductManagerMongo implements ProductManager {
	@PersistenceContext(unitName="Products")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		return entityManager.createQuery("FROM Product p").getResultList();
	}

	@Override
	public Product findById(long id) {
		String queryString = "db.Product.find({'id': " + id +"})";
		return entityManager.createNamedQuery(queryString, Product.class).getSingleResult();
	}

	@Override
	public List<Product> findByNameLike(String name) {
		String queryString = "db.Product.find({'name': " + name +"})";
		return entityManager.createNamedQuery(queryString, Product.class).getResultList();
	}

	@Override
	public List<Product> findByDescriptionLike(String description) {
		String queryString = "db.Product.find({'description': " + description +"})";
		return entityManager.createNamedQuery(queryString, Product.class).getResultList();
	}
}