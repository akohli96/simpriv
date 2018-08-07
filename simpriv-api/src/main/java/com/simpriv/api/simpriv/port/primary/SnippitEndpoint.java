package com.simpriv.api.simpriv.port.primary;

import com.simpriv.api.simpriv.application.snippet.SnippetDTO;
import com.simpriv.api.simpriv.application.user.UserFilterBean;
import org.springframework.security.access.annotation.Secured;

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
	Response create(@HeaderParam("password") String password, @HeaderParam("username") String username);

}
