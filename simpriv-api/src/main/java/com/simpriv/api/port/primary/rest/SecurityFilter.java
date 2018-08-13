package com.simpriv.api.port.primary.rest;

import com.simpriv.api.domain.user.User;
import com.simpriv.api.domain.user.UserRepository;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

    @Context
    private HttpServletRequest servletRequest;

    @Inject
    private UserRepository userRepository;

    public SecurityFilter(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        MultivaluedMap<String, String> headers = requestContext.getHeaders();
        User userFrom = userRepository.getByPassword(headers.get("password").get(0));
        if(userFrom==null){
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .build());
        }
        if(requestContext.getUriInfo().getPath().contains("snippet")){
            User userTo = userRepository.getByUsername(headers.get("username").get(0));
            this.servletRequest.setAttribute("receiver",userTo);
        }
        this.servletRequest.setAttribute("sender",userFrom);
    }
}
