package com.qac.oc.entities.sql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.qac.oc.util.ProductStatus;

@Entity
@Table(name="stockItems")
public class Stock {
	@Id
	private long stockId;
	@NotNull
	@Size(min=3, max=225)
	@Column(name="name", nullable=false, length=225)
	private String name;
	@NotNull
	@Size(min=5, max=12)
	@Column(name="status", nullable=false, length=12)
	private ProductStatus status;
	@NotNull
	@Column(name="price", nullable=false)
	private float price;
	@NotNull
	@Column(name="stock", nullable=false)
	private int stockLevel;
}
