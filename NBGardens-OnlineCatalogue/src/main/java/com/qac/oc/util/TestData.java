package com.qac.oc.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.qac.oc.entities.Address;
import com.qac.oc.entities.Customer;
import com.qac.oc.entities.Product;
import com.qac.oc.entities.Rating;
import com.qac.oc.entities.Stock;
import com.qac.oc.enums.ProductStatus;

@Startup
@Singleton
public class TestData {
	private List<Product> products;
	private List<Stock> stocks;
	private List<Customer> customers;
	
	public TestData() { }
	
	@PostConstruct
	private void setupData() {
		products = new ArrayList<>();
		stocks = new ArrayList<>();
		customers = new ArrayList<>();

		List<String> catagories = new ArrayList<>();
		catagories.add("gnome");
		catagories.add("kids");
		catagories.add("parody");

		products.add(new Product(1, "Garry Gnome", "A Cute SpungeBob Squarepants theamed Gnome", catagories, 2.5 ,15.3, 5.3, 15.5, new Rating(4, "Lives in a Pinnaple Under the Sea", "A charming little gnome, perfect for younger kids!", 1)));
		stocks.add(new Stock(1, "Garry Gnome", ProductStatus.ACTIVE, 25.5f, 100));
		products.add(new Product(2, "Brad Gnome", "A grumpy gnome that hates being called brad"));
		stocks.add(new Stock(2, "Brad Gnome", ProductStatus.ACTIVE, 35.5f, 200));
		products.add(new Product(3, "Santa Gnome", "A very festive gnome who loves giving presents"));
		stocks.add(new Stock(3, "Santa Gnome", ProductStatus.WINTER, 50f, 100));
		products.add(new Product(4, "Bunny Gnome", "A gnome whos just hopping to meet you soon!"));
		stocks.add(new Stock(4, "Bunny Gnome", ProductStatus.SPRING, 43.6f, 300));
		products.add(new Product(5, "Happy Gnome", "A very happy fella indeed"));
		stocks.add(new Stock(5, "Happy Gnome", ProductStatus.SUMMER, 55.5f, 500));
		products.add(new Product(6, "Zombie Gnome", "This gnome is undead and thirsty for brains!"));
		stocks.add(new Stock(6, "Zombie Gnome", ProductStatus.AUTUM, 30.6f, 300));
		products.add(new Product(7, "Game of Gnomes", "These Gnomes are playing a game together. Also, several are dead..."));
		stocks.add(new Stock(7, "Game of Gnomes", ProductStatus.ACTIVE, 60.7f, 1000));
		products.add(new Product(8, "Count Gnomula", "A gnome of the night who will feast, on your blood!"));
		stocks.add(new Stock(8, "Count Gnomula", ProductStatus.AUTUM, 44.5f, 300));
		products.add(new Product(9, "Waregnome", "Man by day, Gnome by night, it's the Waregnome!"));
		stocks.add(new Stock(9, "Waregnome", ProductStatus.DISCONTINUED, 99.99f, 100));
		products.add(new Product(10, "Death Gnome", "This gnome appears to those who are about to die"));
		stocks.add(new Stock(10, "Death Gnome", ProductStatus.DISCONTINUED, 60.4f, 0));
		products.add(new Product(11, "Elf Gnome", "This gnome works for Santa gnome to make lots of lovely toys"));
		stocks.add(new Stock(11, "Elf Gnome", ProductStatus.WINTER, 20f, 500));
		products.add(new Product(12, "Inspector Gnome", "This gnome is always looking for clues"));
		stocks.add(new Stock(12, "Inspector Gnome", ProductStatus.ACTIVE, 56.4f, 200));
		products.add(new Product(13, "Geek Gnome", "This gnome does not agree with you prefering star wars over star trek."));
		stocks.add(new Stock(13, "Geek Gnome", ProductStatus.SUMMER, 36.7f, 100));
		
		customers.add(new Customer(1, "Gnome", "Lover", "gnome@lover.com", "gn0m3s", new Address(1, "1 Garden Way", "Gnometon", "GN03 6DN"), LocalDate.now(ZoneId.of("Europe/London"))));
	}

	public List<Product> getProducts() { return products; }
	public List<Customer> getCustomers() { return customers; }
	public List<Stock> getStock() { return stocks; }
	
	public void setProducts(List<Product> products) { this.products = products; }
	public void setCustomers(List<Customer> customers) { this.customers = customers; }
}