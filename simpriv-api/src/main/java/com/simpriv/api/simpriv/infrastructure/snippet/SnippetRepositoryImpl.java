package com.simpriv.api.simpriv.infrastructure.snippet;

import javax.inject.Inject;

import com.simpriv.api.simpriv.domain.snippet.SnippetRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.simpriv.api.simpriv.domain.snippet.Snippet;

@Component
public class SnippetRepositoryImpl implements SnippetRepository {

	private JdbcTemplate jdbcTemplate;
	private SnippetRowMapper snippetRowMapper;
	
	private static final String insertQuery = "INSERT INTO SNIPPET " + "(MESSAGE_TEXT,PASSWORD_HASH,URL_LINK) VALUES (?, ?, ?)";
	private static final String selectQuery = "SELECT * FROM SNIPPET WHERE URL_LINK = ?";
	private static final String deleteQuery = "DELETE FROM SNIPPET WHERE URL_LINK = ?";
	
	@Inject
	public SnippetRepositoryImpl(JdbcTemplate jdbcTemplate,SnippetRowMapper snippetRowMapper) {
		this.jdbcTemplate=jdbcTemplate;
		this.snippetRowMapper=snippetRowMapper;
	}
	
	@Override
	public String createSnippet(Snippet snippet) {
		jdbcTemplate.update(insertQuery, snippet.getMessage(),snippet.getHash(),snippet.getId());
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
