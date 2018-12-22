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
	
	private static final String insertQuery =  "INSERT INTO SNIPPET " + "(MESSAGE,UUID,SENDER,RECEIVER) VALUES (?, ?, ?, ?)";

	private static final String selectQuery =  "SELECT\n" +
            "  SNIPPET.UUID as UUID,\n" +
            "  SNIPPET.MESSAGE as MESSAGE,\n" +
			"  SNIPPET.RECEIVER as RECEIVER_USERNAME,\n" +
			"  RECEIVER.PASSWORD as RECEIVER_PASSWORD,\n" +
			"  RECEIVER.ENABLED as RECEIVER_ENABLED\n" +
			"  RECEIVER.ROLE as RECEIVER_ROLE\n" +
			"  SENDER.ROLE as SENDER_ROLE\n" +
			"  SNIPPET.SENDER as SENDER_USERNAME,\n" +
			"  SENDER.PASSWORD as SENDER_PASSWORD\n" +
			"  SENDER.ENABLED as SENDER_ENABLED\n" +
			"  FROM\n" +
			"  SNIPPET\n" +
			"  INNER JOIN USERS RECEIVER ON SNIPPET.RECEIVER = RECEIVER.USERNAME\n" +
			"  INNER JOIN USERS SENDER ON SNIPPET.SENDER = SENDER.USERNAME\n" +
			"  WHERE\n" +
			"  SNIPPET.UUID = ?";

	private static final String deleteQuery = "DELETE FROM SNIPPET WHERE UUID = ?";
	
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
