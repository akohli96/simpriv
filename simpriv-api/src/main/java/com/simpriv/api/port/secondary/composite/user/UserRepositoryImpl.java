package com.simpriv.api.port.secondary.composite.user;

import java.util.List;
import javax.inject.Inject;

import com.simpriv.api.port.primary.dto.UserCreateCommand;
import com.simpriv.api.domain.user.User;
import com.simpriv.api.domain.user.UserRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.simpriv.api.utility.Hasher;

@Component
public class UserRepositoryImpl implements UserRepository {

	private static final String getAllQuery="SELECT * FROM USERS";
	private static final String insertQuery="INSERT INTO USERS (USERNAME ,PASSWORD_HASH) VALUES (?, ?)";
	private static final String getByUsernameQuery="SELECT USER * FROM USERS WHERE USERNAME = ?";
	private static final String getByPasswordQuery="SELECT USER * FROM USERS WHERE PASSWORD_HASH = ?";
	
	private JdbcTemplate jdbcTemplate;
	private Hasher keyRetrieval;
	private UserRowMapper userRowMapper;
	
	@Inject
	public UserRepositoryImpl(JdbcTemplate jdbcTemplate, Hasher keyRetrieval, UserRowMapper userRowMapper) {
		this.jdbcTemplate=jdbcTemplate;
		this.keyRetrieval=keyRetrieval;
		this.userRowMapper=userRowMapper;
	}
	
	@Override
	public List<User> getAll() {
		return jdbcTemplate.query(getAllQuery, userRowMapper);
	}

	@Override
	public User create(UserCreateCommand userDTO) {
		try {
			User user = new User(userDTO.getName());
			jdbcTemplate.update(insertQuery, user.getName());
			return user;
		} catch (DataAccessException e ) {
			throw new UserRepositoryException(e);
		}
	}

	@Override
	public User getByUsername(String username)  {
		return jdbcTemplate.queryForObject(getByUsernameQuery, new Object[] {username}, userRowMapper );
	}
	
	@Override
	public User getByPassword(String password) {
		return jdbcTemplate.queryForObject(getByPasswordQuery, new Object[] {password}, userRowMapper );
	}

}
