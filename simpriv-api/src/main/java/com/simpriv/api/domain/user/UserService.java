package com.simpriv.api.domain.user;

import java.util.List;

import com.simpriv.api.domain.user.User;
import com.simpriv.api.port.primary.dto.UserCreateCommand;

public interface UserService {

	List<UserCreateCommand> getAll();
	User create(UserCreateCommand userCreateCommand);
	User getByUsername(String username);
	User getByPassword(String password);
}
