package com.qac.oc.controllers;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.qac.oc.entities.Catagory;
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
	@Produces
	@Path("/browse")
	public String retrieveByCatagory(@QueryParam("catagory") @DefaultValue("all") String catagory) {
		List<Product> results = catagoryService.filterByCatagory(catagory);
		//TODO
		return null;
	}
	
	@GET
	@Produces
	@Path("/{id}")
	public String retrieveById(@PathParam("id") String id) {
		Product result = productService.findProductById(id);
		//TODO
		return null;
	}
}