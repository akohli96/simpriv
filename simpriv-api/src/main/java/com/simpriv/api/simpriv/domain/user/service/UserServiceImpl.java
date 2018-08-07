package com.simpriv.api.simpriv.domain.user.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.simpriv.api.simpriv.application.user.UserDTO;
import com.simpriv.api.simpriv.domain.user.UserService;

import org.springframework.stereotype.Component;

import com.simpriv.api.simpriv.domain.user.User;
import com.simpriv.api.simpriv.domain.user.UserRepository;
import com.simpriv.api.simpriv.exception.SimPrivException;

@Component
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Inject
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	public List<UserDTO> getAll() {
		return userRepository.getAll().stream()
                .map(User::convertToDTO)
                .collect(Collectors.toList());
	}

	@Override
	public User create(UserDTO userDTO) throws SimPrivException {
		return userRepository.create(userDTO);
	}

	@Override
	public User getByUsername(String username) throws SimPrivException {
		return userRepository.getByUsername(username);
	}

	@Override
	public User getByPassword(String password) throws SimPrivException {
		return userRepository.getByPassword(password);
	}
	
}
