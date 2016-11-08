package com.qac.oc.util;

import java.util.List;

import com.qac.oc.entities.Rating;
import com.qac.oc.enums.ProductStatus;

public class ProductItem {
	private long id;
	private String name;
	private String description;
	private double height;
	private double width;
	private double depth;
	private double weight;
	private List<String> categories;
	private List<Rating> ratings;
	private int stockLevel;
	private ProductStatus status;
	private float price;

	public ProductItem(long id) {
		this.id = id;
	}
	
	public ProductItem(long id, String name, String description, double height, double width, double depth, double weight, List<String> categories, List<Rating> ratings, int stockLevel, ProductStatus status, float price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.weight = weight;
		this.categories = categories;
		this.ratings = ratings;
		this.stockLevel = stockLevel;
		this.status = status;
		this.price = price;
	}

	public void addProductInfo(String name, String description, double height, double width, double depth,
			double weight, List<String> categories, List<Rating> ratings) {
		this.name = name;
		this.description = description;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.weight = weight;
		this.categories = categories;
		this.ratings = ratings;
	}

	public void addStockInfo(int stockLevel, ProductStatus status, float price) {
		this.stockLevel = stockLevel;
		this.status = status;
		this.price = price;
	}

	public long getId() { return id; }
	public String getName() { return name; }
	public String getDescription() { return description; }
	public double getHeight() { return height; }
	public double getWidth() { return width; }
	public double getDepth() { return depth; }
	public double getWeight() { return weight; }
	public List<String> getCategories() { return categories; }
	public List<Rating> getRatings() { return ratings; }
	public int getStockLevel() { return stockLevel; }
	public ProductStatus getStatus() { return status; }
	public float getPrice() { return price; }
}