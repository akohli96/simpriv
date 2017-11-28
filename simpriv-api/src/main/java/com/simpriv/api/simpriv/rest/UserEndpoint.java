package com.simpriv.api.simpriv.rest;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.simpriv.api.simpriv.dao.user.dto.UserDTO;

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