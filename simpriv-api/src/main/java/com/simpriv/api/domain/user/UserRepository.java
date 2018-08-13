package com.simpriv.api.domain.user;

import java.util.List;

import com.simpriv.api.port.secondary.composite.user.UserRepositoryException;
import com.simpriv.api.port.primary.dto.UserCreateCommand;

public interface UserRepository {

	List<User> getAll();
	User create(UserCreateCommand user);
	User getByUsername(String username);
	User getByPassword(String password);
}
