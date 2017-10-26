package com.simpriv.api.simpriv.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

@Path("users")
public interface UserEndpoint{

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getAll();
}