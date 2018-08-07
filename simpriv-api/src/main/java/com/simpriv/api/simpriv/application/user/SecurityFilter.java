package com.simpriv.api.simpriv.application.user;

import com.simpriv.api.simpriv.domain.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

    @Context
    private HttpServletRequest servletRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if(requestContext.getUriInfo().getPath().contains("snippet")){
            MultivaluedMap<String, String> headers = requestContext.getHeaders();
            headers.get("password");
            headers.get("username");
            this.servletRequest.setAttribute("sender", new User(null,null));
            this.servletRequest.setAttribute("receiver", new User(null,null));
            //Object myObject = this.servletRequest.getAttribute("My data");

        }
    }
}
