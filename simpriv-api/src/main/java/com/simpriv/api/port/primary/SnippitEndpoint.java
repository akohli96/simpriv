package com.simpriv.api.port.primary;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.simpriv.api.port.primary.dto.SnippetCreateCommand;

@Path("snippet")
public interface SnippitEndpoint{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    Response getById(@PathParam("id") String id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
	Response create(SnippetCreateCommand snippetCreateCommand);

}
