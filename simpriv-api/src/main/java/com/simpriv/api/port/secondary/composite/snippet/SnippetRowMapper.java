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
	    User userTo = new User(rs.getString("snippet.user_to"),rs.getString("userTo.password_hash"));
        User userFrom = new User(rs.getString("snippet.user_from"),rs.getString("userFrom.password_hash"));
        return new Snippet(userFrom,userTo,rs.getString("snippet.message_text"),rs.getString("snippet.url_link"));
	}
}
/*
SELECT snippet.url_link, snippet.message_text,snippet.user_to,snippet.password_hash
 ,userTo.password_hash, snippet.user_from,userFrom.password_hash
FROM table snippet
INNER JOIN users userTo
   ON snippet.user_to = userTo.user_to
INNER JOIN users userFrom
   ON snippet.user_to = userFrom.user_from
 */