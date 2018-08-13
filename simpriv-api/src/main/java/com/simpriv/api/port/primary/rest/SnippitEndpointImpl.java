package com.simpriv.api.port.primary.rest;

import com.simpriv.api.domain.user.User;
import com.simpriv.api.object.SnippetAssembler;
import com.simpriv.api.port.primary.SnippitEndpoint;
import com.simpriv.api.application.snippet.SnippitService;

import com.simpriv.api.port.primary.dto.SnippetCreateCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;


//TODO: Password checking

@Component
public class SnippitEndpointImpl implements SnippitEndpoint {

	private static final Logger log = LoggerFactory.getLogger(SnippitEndpointImpl.class);
	
    private SnippitService snippitService;
    private SnippetAssembler snippetMapper;

    @Inject
    public SnippitEndpointImpl(SnippitService snippitService,SnippetAssembler snippetMapper){
        this.snippitService=snippitService;
        this.snippetMapper=snippetMapper;
    }

    @Override
    public Response getById(HttpServletRequest request, String id, String password) {
        User from= (User) request.getSession().getAttribute("sender");
        snippitService.getByID(from,id);
        return Response.accepted(
                null)
                .build();
    }

	@Override
    public Response create(HttpServletRequest request, String password, String username, SnippetCreateCommand snippetCreateCommand) {
        System.out.println("Hitting create");
        System.out.println(password + " " + username);
        User from= (User) request.getSession().getAttribute("sender");
        User to= (User) request.getSession().getAttribute("receiver");

        snippitService.sendMessage(from,to,snippetCreateCommand.getMessage());
		return null;
	}


}