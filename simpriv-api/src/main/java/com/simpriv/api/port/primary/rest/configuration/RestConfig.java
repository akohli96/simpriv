package com.simpriv.api.port.primary.rest.configuration;

import com.simpriv.api.port.primary.rest.SecurityFilter;
import com.simpriv.api.port.primary.rest.SnippitEndpointImpl;
import com.simpriv.api.port.primary.rest.UserEndpointImpl;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api/v1")
public class RestConfig extends ResourceConfig{
    public RestConfig(){
        register(SecurityFilter.class);
        register(SnippitEndpointImpl.class);
        register(UserEndpointImpl.class);

    }
}