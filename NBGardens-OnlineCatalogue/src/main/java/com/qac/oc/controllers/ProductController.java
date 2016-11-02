package com.qac.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qac.oc.controllers.session.SelectedProduct;
import com.qac.oc.entities.mongo.Product;
import com.qac.oc.services.ProductService;

@Named("products")
@Path("/products")
@RequestScoped
public class ProductController {
	@Inject
	private SelectedProduct product;
	@Inject
	private ProductService productService;
	
	public String view(long id) {
		product.setProduct(productService.getProductItem(id));
		return "product";
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product select(@PathParam("id") String id) {
		return productService.findProductById(id);
	}
}