package com.simpriv.api.port.primary.rest.endpoint;

import com.simpriv.api.application.snippet.AuthenticationFacade;
import com.simpriv.api.domain.snippet.SnippetService;
import com.simpriv.api.port.primary.SnippitEndpoint;

import com.simpriv.api.port.primary.dto.SnippetCreateCommand;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Component
public class SnippitEndpointImpl implements SnippitEndpoint {

    private SnippetService snippitService;
    private AuthenticationFacade authenticationFacade;


    @Inject
    public SnippitEndpointImpl(SnippetService snippitService, AuthenticationFacade authenticationFacade){
        this.snippitService=snippitService;
        this.authenticationFacade=authenticationFacade;
    }

    @Override
    public Response getById( String id) {

        return Response.accepted(
                snippitService.getByID(authenticationFacade.getUserFromContext(),id))
                .build();
    }

	@Override
    public Response create(SnippetCreateCommand snippetCreateCommand) {

        return Response.accepted(
                snippitService.sendMessage(authenticationFacade.getUserFromContext(),snippetCreateCommand))
                .build();
	}

}