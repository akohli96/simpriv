package com.simpriv.api.application.user;

import java.util.List;

import com.simpriv.api.domain.user.User;
import com.simpriv.api.port.primary.dto.UserCreateCommand;
import com.simpriv.api.exception.SimPrivException;

public interface UserService {

	List<UserCreateCommand> getAll();
	User create(UserCreateCommand userDTO);
	User getByUsername(String username);
	User getByPassword(String password);
}
