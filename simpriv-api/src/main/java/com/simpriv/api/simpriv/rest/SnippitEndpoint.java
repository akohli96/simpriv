package com.simpriv.api.simpriv.rest;

import com.simpriv.api.simpriv.object.SnippetDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("snippet")
public interface SnippitEndpoint{


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    Response getById(@PathParam("id") String id, @HeaderParam("password") String password);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
	Response create(@HeaderParam("password") String password, @HeaderParam("username") String username, SnippetDTO snippet);

}
