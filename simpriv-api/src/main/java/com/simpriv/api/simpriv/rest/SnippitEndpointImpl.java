package com.simpriv.api.simpriv.rest;

import com.simpriv.api.simpriv.exception.SimPrivException;
import com.simpriv.api.simpriv.object.SnippetDTO;
import com.simpriv.api.simpriv.object.SnippetAssembler;
import com.simpriv.api.simpriv.service.SnippitService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


//TODO: Password checking
@Component
public class SnippitEndpointImpl implements SnippitEndpoint {

	private static final Logger log = LoggerFactory.getLogger(SnippitEndpointImpl.class);
	
    private SnippitService snippitService;
    private SnippetAssembler snippetMapper; //TODO: Move to service layer

    @Inject
    public SnippitEndpointImpl(SnippitService snippitService,SnippetAssembler snippetMapper){
        this.snippitService=snippitService;
        this.snippetMapper=snippetMapper;
    }

    @Override
    public Response getById(String id, String password) {
    	try {
			return Response.accepted(
					snippetMapper.convertToDTO(snippitService.getById(id), password))
					.build();
		} catch (SimPrivException e) {
			log.info("SimPrivException in create", e);
			throw new WebApplicationException(e);
		}
    }

	@Override
	public Response create(String password, String username, SnippetDTO snippet) {
		try {
			return Response.accepted(snippitService.create(
					 snippetMapper.convertToEntity(snippet, username,password)))
					.build();
		} catch (SimPrivException e) {
			log.info("SimPrivException in create", e);
			throw new WebApplicationException(e);
		}
	}

}