package com.qac.oc.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import com.qac.oc.entities.mongo.Product;
import com.qac.oc.entities.mongo.Rating;
import com.qac.oc.enums.ProductStatus;

@Singleton
public class TestData {
	private List<Product> products;
	
	public TestData() { }
	
	@PostConstruct
	private void setupData() {
		List<String> catagories = new ArrayList<>();
		catagories.add("gnome");
		catagories.add("kids");
		catagories.add("parody");
		List<Rating> ratings = new ArrayList<>();
		ratings.add(new Rating(4, "Lives in a Pinnaple Under the Sea", "A charming little gnome, perfect for younger kids!", 1));
		new Product(1, "Garry Gnome", "A Cute SpungeBob Squarepants theamed Gnome", catagories, 2.5 ,15.3, 5.3, 15.5, ratings);
		products.add(new Product(1, "Garry Gnome", "A Cute SpungeBob Squarepants theamed Gnome", catagories, 2.5 ,15.3, 5.3, 15.5, ratings));
		products.add(new Product(2, "Brad Gnome", 40.50f, 80, ProductStatus.ACTIVE));
		products.add(new Product(3, "Santa Gnome", 36.80f, 2, ProductStatus.WINTER));
		products.add(new Product(4, "Bunny Gnome", 52.20f, 4, ProductStatus.SPRING));
	}

	public List<Product> getProducts() { return products; }

	public void setProducts(List<Product> products) { this.products = products; }
}