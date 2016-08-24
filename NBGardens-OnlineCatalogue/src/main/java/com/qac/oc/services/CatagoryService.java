package com.qac.oc.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.oc.entities.Catagory;
import com.qac.oc.entities.Product;
import com.qac.oc.repositories.CatagoryRepository;
import com.qac.oc.repositories.ProductRepository;

@Stateless
public class CatagoryService {
	@Inject
	private CatagoryRepository catagoryRepository;
	@Inject
	private ProductRepository productRepository;

	public List<Product> filterByCatagory(String catagory) {
		if(catagory.equalsIgnoreCase("all"))
			return productRepository.findAll();
		return pullProductsFromCatagories(catagoryRepository.findByCatagory(catagory));
	}
	
	private List<Product> pullProductsFromCatagories(List<Catagory> catagories) {
		List<Product> products = new ArrayList<>();
		for (Catagory catagory : catagories) {
			products.add(catagory.getProduct());
		}
		return products;
	}
}