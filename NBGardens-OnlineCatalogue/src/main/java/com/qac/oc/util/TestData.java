package com.qac.oc.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.qac.oc.entities.mongo.Product;
import com.qac.oc.entities.mongo.Rating;
import com.qac.oc.entities.sql.Customer;
import com.qac.oc.entities.sql.Stock;

@Startup
@Singleton
public class TestData {
	private List<Product> products;
	
	public TestData() { }
	
	@PostConstruct
	private void setupData() {
		products = new ArrayList<>();
		List<String> catagories = new ArrayList<>();
		List<Rating> ratings = new ArrayList<>();
		catagories.add("gnome");
		catagories.add("kids");
		catagories.add("parody");
		ratings.add(new Rating(4, "Lives in a Pinnaple Under the Sea", "A charming little gnome, perfect for younger kids!", 1));

		products.add(new Product(1, "Garry Gnome", "A Cute SpungeBob Squarepants theamed Gnome", catagories, 2.5 ,15.3, 5.3, 15.5, ratings));
		products.add(new Product(2, "Brad Gnome", "A grumpy gnome that hates being called brad"));
		products.add(new Product(3, "Santa Gnome", "A very festive gnome who loves giving presents"));
		products.add(new Product(4, "Bunny Gnome", "A gnome whos just hopping to meet you soon!"));
		products.add(new Product(5, "Happy Gnome", "A very happy fella indeed"));
		products.add(new Product(6, "Zombie Gnome", "This gnome is undead and thirsty for brains!"));
		products.add(new Product(7, "Game of Gnomes", "These Gnomes are playing a game together. Also, several are dead..."));
		products.add(new Product(8, "Count Gnomula", "A gnome of the night who will feast, on your blood!"));
		products.add(new Product(9, "Waregnome", "Man by day, Gnome by night, it's the Waregnome!"));
		products.add(new Product(10, "Death Gnome", "This gnome appears to those who are about to die"));
		products.add(new Product(11, "Elf Gnome", "This gnome works for Santa gnome to make lots of lovely toys"));
		products.add(new Product(12, "Inspector Gnome", "This gnome is always looking for clues"));
		products.add(new Product(13, "Geek Gnome", "This gnome does not agree with you prefering star wars over star trek."));
	}

	public List<Product> getProducts() { return products; }

	public void setProducts(List<Product> products) { this.products = products; }

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCustomers(List<Customer> customers) {
		// TODO Auto-generated method stub
		
	}

	public List<Stock> getStock() {
		// TODO Auto-generated method stub
		return null;
	}
}