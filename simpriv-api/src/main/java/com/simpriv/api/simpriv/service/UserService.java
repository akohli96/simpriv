package com.simpriv.api.simpriv.service;

import java.util.List;

import com.simpriv.api.simpriv.dao.user.User;
import com.simpriv.api.simpriv.dao.user.dto.UserDTO;
import com.simpriv.api.simpriv.exception.SimPrivException;

public interface UserService {

	List<UserDTO> getAll();
	User create(UserDTO userDTO) throws SimPrivException;
	User getByUsername(String username) throws SimPrivException;
}
