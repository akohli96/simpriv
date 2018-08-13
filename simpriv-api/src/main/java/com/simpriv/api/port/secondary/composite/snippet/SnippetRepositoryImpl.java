package com.simpriv.api.port.secondary.composite.snippet;

import javax.inject.Inject;

import com.simpriv.api.domain.snippet.SnippetRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.simpriv.api.domain.snippet.Snippet;

@Component
public class SnippetRepositoryImpl implements SnippetRepository {

	private JdbcTemplate jdbcTemplate;
	private SnippetRowMapper snippetRowMapper;
	
	private static final String insertQuery = "INSERT INTO SNIPPET " + "(MESSAGE_TEXT,URL_LINK,USER_FROM,USER_TO) VALUES (?, ?, ?, ?)";
	private static final String selectQuery = "SELECT * FROM SNIPPET WHERE URL_LINK = ?";
	private static final String deleteQuery = "DELETE FROM SNIPPET WHERE URL_LINK = ?";
	
	@Inject
	public SnippetRepositoryImpl(JdbcTemplate jdbcTemplate,SnippetRowMapper snippetRowMapper) {
		this.jdbcTemplate=jdbcTemplate;
		this.snippetRowMapper=snippetRowMapper;
	}
	
	@Override
	public String createSnippet(Snippet snippet) {
		jdbcTemplate.update(insertQuery, snippet.getMessage(), snippet.getId(), snippet.getSender().getName(), snippet.getReceiver().getName());
		return snippet.getId();
	}

	@Override
	public Snippet getByID(String Id) {
		return jdbcTemplate.queryForObject(selectQuery, new Object[] {Id}, snippetRowMapper );
	}

	@Override
	public void delete(String Id) {
		jdbcTemplate.update(deleteQuery, Id);
	}

}
