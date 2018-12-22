package com.simpriv.api.port.primary.rest.endpoint;

import com.simpriv.api.domain.snippet.SnippetService;
import com.simpriv.api.domain.user.custom.CustomUserPrincipal;
import com.simpriv.api.port.primary.SnippitEndpoint;

import com.simpriv.api.port.primary.dto.SnippetCreateCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Component
public class SnippitEndpointImpl implements SnippitEndpoint {

	private static final Logger log = LoggerFactory.getLogger(SnippitEndpointImpl.class);
	
    private SnippetService snippitService;


    @Inject
    public SnippitEndpointImpl(SnippetService snippitService){
        this.snippitService=snippitService;
    }

    @Override
    public Response getById( String id) {
        CustomUserPrincipal principal = (CustomUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return Response.accepted(
                snippitService.getByID(principal,id))
                .build();
    }

	@Override
    public Response create(SnippetCreateCommand snippetCreateCommand) {

        CustomUserPrincipal principal = (CustomUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return Response.accepted(
                snippitService.sendMessage(principal,snippetCreateCommand))
                .build();
	}

}