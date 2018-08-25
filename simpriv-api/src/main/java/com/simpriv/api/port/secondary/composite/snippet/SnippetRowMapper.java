package com.simpriv.api.port.secondary.composite.snippet;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.simpriv.api.domain.user.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.simpriv.api.domain.snippet.Snippet;

@Component
public class SnippetRowMapper implements RowMapper<Snippet>{

	@Override
	public Snippet mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println(rs);
	    User userTo = new User(rs.getString("USER_TO_USERNAME"),rs.getString("USER_TO_PASSWORD"));
        User userFrom = new User(rs.getString("USER_FROM_USERNAME"),rs.getString("USER_FROM_PASSWORD"));
        return new Snippet(userFrom,userTo,rs.getString("MESSAGE"),rs.getString("UUID"));
	}
}