package simpriv.configuration;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

import org.springframework.context.annotation.Configuration;

import simpriv.rest.UserEndpointImpl;

@Configuration
@ApplicationPath("/api/v1")
public class RestConfig extends ResourceConfig{
    public RestConfig(){
        register(UserEndpointImpl.class);
    }
}