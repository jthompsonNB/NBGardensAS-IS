package com.qac.oc.controllers;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qac.oc.entities.Product;
import com.qac.oc.services.SearchService;

@Path("/search")
@RequestScoped
public class SearchController {
	@Inject
	private SearchService searchService;
	
	@GET
	@Path("/{term}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> search(@PathParam("term") String term) {
		return searchService.findByKeyword(term);
	}
}