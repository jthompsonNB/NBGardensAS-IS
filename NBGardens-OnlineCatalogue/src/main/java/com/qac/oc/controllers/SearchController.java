package com.qac.oc.controllers;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qac.oc.entities.Product;
import com.qac.oc.services.SearchService;

@Path("/search")
@RequestScoped
public class SearchController {
	@Inject
	private SearchService searchService;
	
	@GET
	@Path("/")
	@Produces
	public String search(@PathParam("term") String term) {
		List<Product> results = searchService.findByKeyword(term);
		//TODO
		return null;
	}
}