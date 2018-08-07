package com.simpriv.api.simpriv.domain.user;

import java.util.List;

import com.simpriv.api.simpriv.application.user.UserDTO;
import com.simpriv.api.simpriv.exception.SimPrivException;

public interface UserService {

	List<UserDTO> getAll();
	User create(UserDTO userDTO) throws SimPrivException;
	User getByUsername(String username) throws SimPrivException;
	User getByPassword(String password) throws SimPrivException;
}
