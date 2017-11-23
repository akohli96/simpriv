package com.simpriv.api.simpriv.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.simpriv.api.simpriv.object.Snippet;

@Component
public class SnippetDAOImpl implements SnippetDAO {

	private JdbcTemplate jdbcTemplate;
	private SnippetRowMapper snippetRowMapper;
	
	private static final String insertQuery = "INSERT INTO SNIPPET " + "(MESSAGE_TEXT,PASSWORD_HASH,URL_LINK) VALUES (?, ?, ?)";
	private static final String selectQuery = "SELECT * FROM SNIPPET WHERE URL_LINK = ?";
	
	@Inject
	public SnippetDAOImpl(JdbcTemplate jdbcTemplate,SnippetRowMapper snippetRowMapper) {
		this.jdbcTemplate=jdbcTemplate;
		this.snippetRowMapper=snippetRowMapper;
	}
	
	@Override
	public String createSnippet(Snippet snippet) {
		jdbcTemplate.update(insertQuery, new Object[] {snippet.getMessage(),snippet.getHash(),snippet.getId()});
		return snippet.getId();
	}

	@Override
	public Snippet getById(String Id) {
		return jdbcTemplate.queryForObject(selectQuery, new Object[] {Id}, snippetRowMapper );
	}

}
