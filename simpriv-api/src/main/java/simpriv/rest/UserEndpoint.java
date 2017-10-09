package simpriv.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.HeaderParam;


@Path("user")
public interface UserEndpoint{

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Object getAll(@HeaderParam("x-api-key") String apiKey, @PathParam("id") String id);
}