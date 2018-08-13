package com.simpriv.api.port.primary;


import com.simpriv.api.port.primary.dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("users")
public interface UserEndpoint{

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response create(UserDTO userDTO);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getAll();

}