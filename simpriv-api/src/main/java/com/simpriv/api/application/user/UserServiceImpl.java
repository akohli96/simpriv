package com.simpriv.api.application.user;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import org.springframework.stereotype.Component;

import com.simpriv.api.domain.user.User;
import com.simpriv.api.domain.user.UserRepository;
import com.simpriv.api.port.primary.dto.UserCreateCommand;


@Component
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Inject
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	public List<UserCreateCommand> getAll() {
	   return userRepository.getAll().stream()
               .map(User::convertToDTO)
               .collect(Collectors.toList());
	}

	@Override
	public User create(UserCreateCommand UserCreateCommand) {
		return userRepository.create(UserCreateCommand);
	}

	@Override
	public User getByUsername(String username)  {
		return userRepository.getByUsername(username);
	}

	@Override
	public User getByPassword(String password)  {
		return userRepository.getByPassword(password);
	}
	
}
