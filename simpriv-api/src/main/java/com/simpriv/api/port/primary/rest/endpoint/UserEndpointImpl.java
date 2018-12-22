package com.simpriv.api.port.primary.rest.endpoint;

import com.simpriv.api.domain.user.UserService;
import com.simpriv.api.port.primary.dto.UserCreateCommand;
import com.simpriv.api.port.primary.UserEndpoint;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Component
public class UserEndpointImpl implements UserEndpoint {

	private UserService userService;

	@Inject
	public UserEndpointImpl(UserService userService) {
		this.userService=userService;
	}


	@Override
	public Response create(UserCreateCommand userCreateCommand) {
        return Response
                .accepted(userService.create(userCreateCommand))
                .build();
	}

    @Override
    public Response getAll() {
        return Response
                .ok(userService.getAll())
                .build();
    }

}