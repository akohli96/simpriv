package com.simpriv.api.simpriv.dao.user;

import java.util.List;
import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.simpriv.api.simpriv.dao.user.dto.UserDTO;
import com.simpriv.api.simpriv.exception.SimPrivException;
import com.simpriv.api.simpriv.utility.Hasher;

//TODO: Password checking
@Component
public class UserDAOImpl implements UserDAO{

	private static final String getAllQuery="SELECT * FROM USERS";
	private static final String insertQuery="INSERT INTO USERS (USERNAME ,PASSWORD_HASH) VALUES (?, ?)";
	private static final String getByUsernameQuery="SELECT * FROM USERS WHERE USERNAME = ?";
	
	private JdbcTemplate jdbcTemplate;
	private Hasher keyRetrieval;
	private UserRowMapper userRowMapper;
	
	@Inject
	public UserDAOImpl(JdbcTemplate jdbcTemplate,Hasher keyRetrieval,UserRowMapper userRowMapper) {
		this.jdbcTemplate=jdbcTemplate;
		this.keyRetrieval=keyRetrieval;
		this.userRowMapper=userRowMapper;
	}
	
	@Override
	public List<User> getAll() {
		return jdbcTemplate.query(getAllQuery, userRowMapper);
	}

	@Override
	public User create(UserDTO userDTO) throws SimPrivException {
		try {
			User user = new User(userDTO.getName()); //TODO: Move this to service layer and hashing too
			jdbcTemplate.update(insertQuery, new Object[] {user.getName(),keyRetrieval.hashString(user.getPassword())});
			return user;
		} catch (DataAccessException | SimPrivException e) {
			throw new SimPrivException(e);
		}
	}

	@Override
	public User getByUsername(String username) throws SimPrivException {
		return jdbcTemplate.queryForObject(getByUsernameQuery, new Object[] {username}, userRowMapper );
	}

}
