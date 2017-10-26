package com.simpriv.api.simpriv.rest;

import org.springframework.stereotype.Component;

import javax.xml.ws.Response;

@Component
public class UserEndpointImpl implements UserEndpoint{

    @Override
    public Response create() {
        /*
            Post
                username
         */
        /*
        return username
                public key
                private key
         */
        return null;
    }

    @Override
    public Response getAll() {
        /*
        return username
                public key
         */
        return null;
    }

}