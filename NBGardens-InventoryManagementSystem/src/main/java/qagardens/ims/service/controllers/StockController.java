package qagardens.ims.service.controllers;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ValidationException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import qagardens.ims.service.entities.pojos.Stock;
import qagardens.ims.service.logic.StockService;

@Path("/stock")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
public class StockController {
	@Inject
	private StockService stockService;
	@Context
	private UriInfo uriInfo;
	
	@POST
	public Response addNewStockLine(Stock stock) {
		if(stock==null)
			return Response.status(Status.NOT_ACCEPTABLE).build();
		try {
			return Response.created(uriInfo.getAbsolutePathBuilder().path(""+stockService.addStock(stock).getId()).build()).build();
		} catch (ValidationException e) {
			return Response.status(Status.EXPECTATION_FAILED).build();
		}
	}
	
	@GET
	@Path("{id}")
	public Response getStock(@PathParam("id") String id){
		Stock stock = stockService.retreiveStock(id);
		if(stock==null)
			return new BadRequestException().getResponse();
		return Response.ok(stock).build();
	}
}