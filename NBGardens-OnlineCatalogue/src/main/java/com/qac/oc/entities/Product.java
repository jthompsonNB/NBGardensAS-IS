package com.qac.oc.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = -6586263742271776754L;
	@Id
	private long id;
	private String name;
	private String description;
	private List<String> categories;
	private double weight;
	private double width;
	private double depth;
	private double height;
	private List<Rating> ratings;

	public Product() {
		ratings = new ArrayList<Rating>();
	}	
	
	public Product(long id, String name, String description, List<String> categories) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.categories = categories;
		ratings = new ArrayList<Rating>();
	}

	public Product(long id, String name, String description, List<String> categories, double weight) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.categories = categories;
		this.weight = weight;
		ratings = new ArrayList<Rating>();
	}

	public Product(long id, String name, String description, List<String> categories, double width, double height) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.categories = categories;
		this.width = width;
		this.height = height;
		ratings = new ArrayList<Rating>();
	}

	public Product(long id, String name, String description, List<String> categories, double width, double depth, double height) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.categories = categories;
		this.width = width;
		this.depth = depth;
		this.height = height;
		ratings = new ArrayList<Rating>();
	}

	public Product(long id, String name, String description, List<String> categories, double weight, double width, double depth, double height) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.categories = categories;
		this.weight = weight;
		this.width = width;
		this.depth = depth;
		this.height = height;
		ratings = new ArrayList<Rating>();
	}

	public Product(long id, String name, String description, List<String> categories, double weight, double width, double depth, double height, Rating rating) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.categories = categories;
		this.weight = weight;
		this.width = width;
		this.depth = depth;
		this.height = height;
		ratings = new ArrayList<>();
		ratings.add(rating);
	}

	public Product(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		ratings = new ArrayList<Rating>();
	}
	
	public void addRating(Rating rating) {
		ratings.add(rating);
	}

	public long getId() { return id; }
	public String getName() { return name; }
	public String getDescription() { return description; }
	public double getWeight() { return weight; }
	public double getWidth() { return width; }
	public double getDepth() { return depth; }
	public double getHeight() { return height; }
	public List<Rating> getRatings() { return ratings; }
	public List<String> getCategories() { return categories; }

	public void setCategories(List<String> categories) { this.categories = categories; }
	public void setName(String name) { this.name = name; }
	public void setDescription(String description) { this.description = description; }
	public void setWeight(double weight) { this.weight = weight; }
	public void setWidth(double width) { this.width = width; }
	public void setDepth(double depth) { this.depth = depth; }
	public void setHeight(double height) { this.height = height; }
	public void setRatings(List<Rating> ratings) { this.ratings = ratings; }
}