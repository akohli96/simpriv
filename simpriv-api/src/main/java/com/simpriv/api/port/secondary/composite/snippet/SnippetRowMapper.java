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
	    User receiver = new User(rs.getString("RECEIVER_USERNAME"),rs.getString("RECEIVER_PASSWORD"),rs.getString("RECEIVER_ROLE"),rs.getBoolean("RECEIVER_ROLE"));
        User sender = new User(rs.getString("SENDER_USERNAME"),rs.getString("SENDER_PASSWORD"),rs.getString("SENDER_ROLE"),rs.getBoolean("SENDER_ROLE"));
        return new Snippet(sender,receiver,rs.getString("MESSAGE"),rs.getString("UUID"));
	}
}