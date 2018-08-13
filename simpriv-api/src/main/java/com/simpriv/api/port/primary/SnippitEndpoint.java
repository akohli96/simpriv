package com.simpriv.api.port.primary;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.simpriv.api.port.primary.dto.SnippetCreateCommand;

@Path("snippet")
public interface SnippitEndpoint{


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    Response getById(@Context HttpServletRequest request, @PathParam("id") String id, @HeaderParam("password") String password);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
	Response create(@Context HttpServletRequest request, @HeaderParam("password") String password, @HeaderParam("username") String username, SnippetCreateCommand snippetCreateCommand);

}
