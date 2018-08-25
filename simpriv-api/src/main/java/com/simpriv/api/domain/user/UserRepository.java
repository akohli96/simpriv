package com.simpriv.api.domain.user;

import java.util.List;

public interface UserRepository {

	List<User> getAll();
	User create(User user);
	User getByUsername(String username);
	User getByPassword(String password);
}
