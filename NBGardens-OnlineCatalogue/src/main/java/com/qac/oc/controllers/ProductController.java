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
import com.qac.oc.entities.Product;
import com.qac.oc.services.ProductService;
import com.qac.oc.util.ProductItem;

@Named("products")
@Path("/products")
@RequestScoped
public class ProductController {
	@Inject
	private SelectedProduct product;
	@Inject
	private ProductService productService;
	
	public String view(long id) {
		ProductItem item = productService.getProductItem(id);
		if (item != null) {
			product.setProduct(item);
			return "product";
		}
		return "browse";
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product select(@PathParam("id") String id) {
		return productService.findProductById(id);
	}
}