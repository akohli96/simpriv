package com.simpriv.api.application.user;

import java.util.List;
import static java.util.stream.Collectors.toList;

import javax.inject.Inject;

import com.simpriv.api.domain.user.UserService;
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
               .collect(toList());
	}

	@Override
	public User create(UserCreateCommand userCreateCommand) {
		return userRepository.create(User.createUserFromCreateCommand(userCreateCommand));
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
