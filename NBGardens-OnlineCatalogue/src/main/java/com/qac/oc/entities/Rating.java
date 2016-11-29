package com.qac.oc.entities;

import java.io.Serializable;

/**
 * This represents the data associated with a rating.
 * 
 * @author James Thompson
 *
 */
public class Rating implements Serializable{
	private static final long serialVersionUID = 2934181567992622667L;
	private long customerId;
	private double rating;
	private String title;
	private String description;
	
	public Rating() { }
	
	public Rating(double rating, String title, String description, long customerId) {
		this.rating = rating;
		this.title = title;
		this.description = description;
		this.customerId = customerId;
	}

	public double getRating() { return rating; }
	public String getTitle() { return title; }
	public String getDescription() { return description; }
	public long getCustomerId() { return customerId; }

	public void setRating(double rating) { this.rating = rating; }
	public void setTitle(String title) { this.title = title; }
	public void setDescription(String description) { this.description = description; }
	public void setCustomerId(long customerId) { this.customerId = customerId; }
}