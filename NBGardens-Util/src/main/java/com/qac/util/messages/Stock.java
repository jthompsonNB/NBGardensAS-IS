package com.qac.util.messages;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.qac.util.enums.ProductStatus;

@Entity
@Table(name="stockItems")
public class Stock {
	@Id
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

	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public ProductStatus getStatus() {
		return status;
	}
	public float getPrice() {
		return price;
	}
	public int getStockLevel() {
		return stockLevel;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStatus(ProductStatus status) {
		this.status = status;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
}