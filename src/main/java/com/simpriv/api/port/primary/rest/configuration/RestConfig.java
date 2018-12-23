package com.simpriv.api.port.primary.rest.configuration;

import com.simpriv.api.port.primary.rest.endpoint.SnippitEndpointImpl;
import com.simpriv.api.port.primary.rest.endpoint.UserEndpointImpl;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api/v1")
public class RestConfig extends ResourceConfig{
    public RestConfig(){
        register(SnippitEndpointImpl.class);
        register(UserEndpointImpl.class);
    }
}