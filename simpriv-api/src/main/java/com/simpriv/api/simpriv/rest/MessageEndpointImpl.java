package com.simpriv.api.simpriv.rest;

import org.springframework.stereotype.Component;

import javax.xml.ws.Response;

@Component
public class MessageEndpointImpl implements MessageEndpoint {

    @Override
    public Response create() {
        /*
            Post
                private key
                receivers_public_key
                message
         */
        /*
        return
            URL Endpoint
         */
        return null;
    }

    @Override
    public Response getById(String id, String privateKey) {
        /*
            create private key
         */
        /*
           returns message
         */
        return null;
    }

}