package com.simpriv.api.simpriv.rest;

import com.simpriv.api.simpriv.exception.SimPrivException;
import com.simpriv.api.simpriv.object.Snippet;
import com.simpriv.api.simpriv.service.SnippitService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


@Component
public class SnippitEndpointImpl implements SnippitEndpoint {

    private SnippitService snippitService;

    @Inject
    public SnippitEndpointImpl(SnippitService snippitService){
        this.snippitService=snippitService;
    }

    @Override
    public Response create(String password, String username, Snippet snippet) {
        try {
            System.out.println("In response");
            System.out.println(password);
            System.out.println(username);
            System.out.println(snippet);
            snippitService.create(password, username, snippet);
            return Response.accepted().build();
        } catch ( SimPrivException e ) {
            System.out.println(e.getMessage());
            throw new WebApplicationException(e);
        }
    }

    @Override
    public Response getById(String id, String password) {
        /*
            create private key
         */
        /*
           returns message
         */
        return null;
    }

}