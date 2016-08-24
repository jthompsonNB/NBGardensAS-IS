package com.qac.oc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.qac.oc.util.ProductStatus;

@Entity
@Table(name="products")
public class Product {
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productID", nullable=false, unique=true)
	private long productId;
	@NotNull
	@Size(min=3, max=225)
	@Column(name="name", nullable=false, length=225)
	private String name;
	@NotNull
	@Size(min=5, max=12)
	@Column(name="name", nullable=false, length=12)
	private ProductStatus status;
	@NotNull
	@Column(name="name", nullable=false)
	private float price;
	@NotNull
	@Column(name="name", nullable=false)
	private int stock;

	public Product() {}
	
	public Product(String name, float price, int stock, ProductStatus status) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.status = status;
	}
	
	public Product(long productId, String name, float price, int stock, ProductStatus status) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.status = status;
	}

	public long getProductId() { return productId; }
	public String getName() { return name; }
	public float getPrice() { return price; }
	public int getStock() { return stock; }
	public ProductStatus getStatus() { return status; }

	public void setProductId(long productId) { this.productId = productId; }
	public void setName(String name) { this.name = name; }
	public void setPrice(float price) { this.price = price; }
	public void setStock(int stock) { this.stock = stock; }
	public void setStatus(ProductStatus status) { this.status = status; }
}