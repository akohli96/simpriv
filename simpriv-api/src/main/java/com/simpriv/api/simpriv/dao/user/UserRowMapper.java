package com.simpriv.api.simpriv.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new User(rs.getString("USERNAME"),rs.getString("PASSWORD_HASH"));
	}

}
