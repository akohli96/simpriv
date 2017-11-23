package com.simpriv.api.simpriv.configuration;

import com.simpriv.api.simpriv.rest.SnippitEndpointImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api/v1")
public class RestConfig extends ResourceConfig{
    public RestConfig(){
        register(SnippitEndpointImpl.class);
    }
}