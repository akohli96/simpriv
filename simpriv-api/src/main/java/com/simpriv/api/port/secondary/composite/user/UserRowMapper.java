package com.simpriv.api.port.secondary.composite.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.simpriv.api.domain.user.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new User(rs.getString("username"),rs.getString("password_hash"));
	}

}
