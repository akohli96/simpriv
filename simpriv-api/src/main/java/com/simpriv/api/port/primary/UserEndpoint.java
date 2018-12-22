package com.simpriv.api.port.primary;


import com.simpriv.api.port.primary.dto.UserCreateCommand;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("user")
public interface UserEndpoint{

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response create(UserCreateCommand userCreateCommand);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getAll();

}