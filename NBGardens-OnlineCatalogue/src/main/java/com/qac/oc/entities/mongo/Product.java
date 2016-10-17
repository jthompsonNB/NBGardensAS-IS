package com.qac.oc.entities.mongo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = -8533501934017532082L;
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

	public Product() {}	
	
	public Product(long id, String name, String description, List<String> categories) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.categories = categories;
	}

	public Product(long id, String name, String description, List<String> categories, double weight) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.categories = categories;
		this.weight = weight;
	}

	public Product(long id, String name, String description, List<String> categories, double width,
			double height) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.categories = categories;
		this.width = width;
		this.height = height;
	}

	public Product(long id, String name, String description, List<String> categories, double width, double depth,
			double height) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.categories = categories;
		this.width = width;
		this.depth = depth;
		this.height = height;
	}

	public Product(long id, String name, String description, List<String> categories, double weight,
			double width, double depth, double height) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.categories = categories;
		this.weight = weight;
		this.width = width;
		this.depth = depth;
		this.height = height;
	}

	public Product(long id, String name, String description, List<String> categories, double weight,
			double width, double depth, double height, List<Rating> ratings) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.categories = categories;
		this.weight = weight;
		this.width = width;
		this.depth = depth;
		this.height = height;
		this.ratings = ratings;
	}

	public Product(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getWeight() {
		return weight;
	}

	public double getWidth() {
		return width;
	}

	public double getDepth() {
		return depth;
	}

	public double getHeight() {
		return height;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj.getClass().equals(this.getClass())) {
			Product product = (Product) obj;
			if (product.id == id)
				return true;
		}
		return false;
	}
}