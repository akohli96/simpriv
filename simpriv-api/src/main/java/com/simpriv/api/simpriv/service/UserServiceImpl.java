package com.simpriv.api.simpriv.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.simpriv.api.simpriv.dao.user.User;
import com.simpriv.api.simpriv.dao.user.UserDAO;
import com.simpriv.api.simpriv.dao.user.dto.UserDTO;
import com.simpriv.api.simpriv.exception.SimPrivException;

@Component
public class UserServiceImpl implements UserService{

	private UserDAO userDAO;
	
	@Inject
	public UserServiceImpl(UserDAO userDAO){
		this.userDAO=userDAO;
	}

	@Override
	public List<UserDTO> getAll() {
		return	userDAO.getAll().stream()
				.map(user -> new UserDTO(user.getName())) //TODO : Check if can use User::getName
				.collect(Collectors.toList());
	}

	@Override
	public User create(UserDTO userDTO) throws SimPrivException {
		return userDAO.create(userDTO);
	}

	@Override
	public User getByUsername(String username) throws SimPrivException {
		return userDAO.getByUsername(username);
	}
	
	
}
