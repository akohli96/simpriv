package com.simpriv.api.port.primary.rest;

import com.simpriv.api.domain.user.User;
import com.simpriv.api.port.primary.SnippitEndpoint;
import com.simpriv.api.application.snippet.SnippitService;

import com.simpriv.api.port.primary.dto.SnippetCreateCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Component
public class SnippitEndpointImpl implements SnippitEndpoint {

	private static final Logger log = LoggerFactory.getLogger(SnippitEndpointImpl.class);
	
    private SnippitService snippitService;

    @Context
    private ContainerRequestContext requestContext;


    @Inject
    public SnippitEndpointImpl(SnippitService snippitService){
        this.snippitService=snippitService;
    }

    @Override
    public Response getById( String id, String password) {
        User sender= (User) requestContext.getProperty("sender");
        return Response.accepted(
                snippitService.getByID(sender,id))
                .build();
    }

	@Override
    public Response create( String password, SnippetCreateCommand snippetCreateCommand) {
        System.out.println("Hitting create");
        User sender= (User) requestContext.getProperty("sender");
        return Response.accepted(
                snippitService.sendMessage(sender,snippetCreateCommand))
                .build();
	}


}