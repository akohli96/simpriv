package com.simpriv.api.port.primary.rest;

import com.simpriv.api.application.user.UserService;
import com.simpriv.api.domain.user.User;
import com.simpriv.api.domain.user.UserRepository;

import com.simpriv.api.port.primary.rest.configuration.UserAuthenticated;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@UserAuthenticated
public class SecurityFilter implements ContainerRequestFilter {

    private UserService userService;

    @Autowired
    public SecurityFilter(UserService userService){
        this.userService=userService;
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        MultivaluedMap<String, String> headers = requestContext.getHeaders();
        User sender = userService.getByPassword(headers.get("password").get(0));
        System.out.println(sender.getName());
        if(sender==null){
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .build());
        }
        requestContext.setProperty("sender",sender);
    }
}
