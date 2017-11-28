package com.simpriv.api.simpriv.dao.user;

import java.util.List;

import com.simpriv.api.simpriv.dao.user.dto.UserDTO;
import com.simpriv.api.simpriv.exception.SimPrivException;

public interface UserDAO {

	List<User> getAll();
	User create(UserDTO user) throws SimPrivException;
	User getByUsername(String username) throws SimPrivException;
}
