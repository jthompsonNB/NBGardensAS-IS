package com.qac.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.qac.oc.services.ProductService;

@RequestScoped
public class ProductController {
	@Inject
	private SelectedProduct product;
	@Inject
	private ProductService productService;
	
	public String view(long id) {
		product.setProduct(productService.findProductById(id));
		return "product";
	}
}