package com.qac.oc.entities;

import java.io.Serializable;

public class ProductDetails implements Serializable{
	private static final long serialVersionUID = 6305862052688446585L;

	private Long id;
	private String name;
	private String description;
	private Rating rating;

	public ProductDetails() { }
	
	public ProductDetails(Long id, String name, String description, Rating rating) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.rating = rating;
	}

	public Long getId() { return id; }
	public String getName() { return name; }
	public String getDescription() { return description; }
	public Rating getRating() { return rating; }

	public void setId(Long id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setDescription(String description) { this.description = description; }
	public void setRating(Rating rating) { this.rating = rating; }
}