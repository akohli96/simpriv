package com.simpriv.api.simpriv.infrastructure.snippet;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.simpriv.api.simpriv.domain.snippet.Snippet;

@Component
public class SnippetRowMapper implements RowMapper<Snippet>{

	@Override
	public Snippet mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Snippet(rs.getString("url_link"), rs.getString("message_text"),rs.getString("password_hash"));
	}
}
