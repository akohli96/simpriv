package com.simpriv.api.port.secondary.composite.user;

import java.util.List;
import javax.inject.Inject;

import com.simpriv.api.port.primary.dto.UserCreateCommand;
import com.simpriv.api.domain.user.User;
import com.simpriv.api.domain.user.UserRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.simpriv.api.utility.Hasher;

@Component
public class UserRepositoryImpl implements UserRepository {

	private static final String getAllQuery="SELECT * FROM USERS";
	private static final String insertQuery="INSERT INTO USERS (USERNAME ,PASSWORD ,ENABLED ,ROLE) VALUES (?, ?, ? , ?)";
	private static final String getByUsernameQuery="SELECT * FROM USERS WHERE USERNAME = ?";
	private static final String getByPasswordQuery="SELECT * FROM USERS WHERE PASSWORD = ?";
	
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
	public User create(User user) {
		try {
			jdbcTemplate.update(insertQuery, user.getName(),user.getPassword(),user.isEnabled(),user.getRole());
			return user;
		} catch (DuplicateKeyException e ) {
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
		//EmptyResultDataAccessException
	}

}
