package com.simpriv.api.simpriv.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

@Path("message")
public interface SnippitEndpoint{

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response create(@HeaderParam("private-key") String privateKey, @HeaderParam("public-key") String publicKey, String message);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    Response getById(@PathParam("id") String id, @HeaderParam("private-key") String privateKey);

}
