package com.simpriv.api.simpriv.port.primary.rest;

import com.simpriv.api.simpriv.application.user.UserDTO;
import com.simpriv.api.simpriv.domain.user.UserService;
import com.simpriv.api.simpriv.port.primary.UserEndpoint;
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
	public Response create(UserDTO userDTO) {
		return null;
	}

	@Override
    public Response getAll() {
		return Response
				.accepted(userService.getAll())
				.build();
    }

}