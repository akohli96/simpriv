package com.simpriv.api.simpriv.rest;

import org.springframework.stereotype.Component;

import com.simpriv.api.simpriv.dao.user.dto.UserDTO;
import com.simpriv.api.simpriv.exception.SimPrivException;
import com.simpriv.api.simpriv.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Component
public class UserEndpointImpl implements UserEndpoint{

	private UserService userService;
	
	@Inject
	public UserEndpointImpl(UserService userService) {
		this.userService=userService;
	}
	
    @Override
    public Response create(UserDTO userDTO) {
        try {
			return Response
					.accepted(userService.create(userDTO))
					.build();
		} catch (SimPrivException e) {
			throw new WebApplicationException(e);
		}
    }

    @Override
    public Response getAll() {
		return Response
				.accepted(userService.getAll())
				.build();
    }

}