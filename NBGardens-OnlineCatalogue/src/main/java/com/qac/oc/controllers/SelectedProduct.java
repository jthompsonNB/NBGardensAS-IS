package com.qac.oc.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.oc.entities.mongo.Product;
import com.qac.oc.entities.sql.Stock;
import com.qac.oc.services.ProductService;
import com.qac.oc.services.StockService;

@SessionScoped
@Named("selected")
public class SelectedProduct implements Serializable{
	@Inject
	private StockService stockService;
	@Inject
	private ProductService productService;
	private Product product;
	private Stock stock;

	public Product getProduct() { return product; }

	public Stock getStock() { return stock; }

	public void setStock(Stock stock) {
		this.stock = stock;
		product = productService.findProductById(this.stock.getId());
	}

	public void setProduct(Product product) {
		this.product = product;
		stock = stockService.findStockById(this.product.getId());
	}	
}