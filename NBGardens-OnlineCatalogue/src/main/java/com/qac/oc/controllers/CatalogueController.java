package com.qac.oc.controllers;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qac.oc.entities.Product;
import com.qac.oc.services.CatagoryService;
import com.qac.oc.services.ProductService;

@RequestScoped 
@Path("/catalogue")
public class CatalogueController {
	@Inject
	private CatagoryService catagoryService;
	@Inject
	private ProductService productService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/browse/{catagory}")
	public List<Product> retrieveByCatagory(@PathParam("catagory") @DefaultValue("all") String catagory) {
		return catagoryService.filterByCatagory(catagory);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Product retrieveById(@PathParam("id") String id) {
		return productService.findProductById(id);
	}
}