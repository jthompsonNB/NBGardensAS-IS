package com.qac.oc.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import com.qac.oc.entities.mongo.Product;

@Singleton
public class TestData {
	private List<Product> products;
	
	public TestData() { }
	
	@PostConstruct
	private void setupData() {
		products = new ArrayList<>();
		
//		products.add(new Product(1, "Garry Gnome", 56.40f, 100, ProductStatus.ACTIVE));
//		products.add(new Product(2, "Brad Gnome", 40.50f, 80, ProductStatus.ACTIVE));
//		products.add(new Product(3, "Santa Gnome", 36.80f, 2, ProductStatus.WINTER));
//		products.add(new Product(4, "Bunny Gnome", 52.20f, 4, ProductStatus.SPRING));
	}

	public List<Product> getProducts() { return products; }

	public void setProducts(List<Product> products) { this.products = products; }
}