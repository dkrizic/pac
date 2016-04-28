package com.prodyna.pac.calculator;

import javax.ws.rs.*;

@Path("/calculator")
@Consumes("application/json")
@Produces("application/json")
public interface CalculatorService {

    @GET
    @Path("add/{a}/{b}")
    int add( @PathParam("a") int a, @PathParam("b") int b );

}
