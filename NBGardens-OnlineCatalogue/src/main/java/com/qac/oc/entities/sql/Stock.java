package com.qac.oc.entities.sql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.qac.oc.enums.ProductStatus;

@Entity
@Table(name="stockItems")
public class Stock {
	@Id
	@Column(nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Size(min=3, max=225)
	@Column(name="name", nullable=false, length=225)
	private String name;
	@NotNull
	@Size(min=5, max=12)
	@Column(name="status", nullable=false, length=12)
	private ProductStatus status;
	@NotNull
	@Column(name="sale_price", nullable=false)
	private float price;
	@NotNull
	@Column(name="stock", nullable=false)
	private int stockLevel;

	public Stock() { }
	
	public Stock(String name, ProductStatus status, float price, int stockLevel) {
		this.name = name;
		this.status = status;
		this.price = price;
		this.stockLevel = stockLevel;
	}
	
	public Stock(long id, String name, ProductStatus status, float price, int stockLevel) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.price = price;
		this.stockLevel = stockLevel;
	}
	
	public long getId() { return id; }
	public String getName() { return name; }
	public ProductStatus getStatus() { return status; }
	public float getPrice() { return price; }
	public int getStockLevel() { return stockLevel; }

	public void setName(String name) { this.name = name; }
	public void setStatus(ProductStatus status) { this.status = status; }
	public void setPrice(float price) { this.price = price; }
	public void setStockLevel(int stockLevel) { this.stockLevel = stockLevel; }
}