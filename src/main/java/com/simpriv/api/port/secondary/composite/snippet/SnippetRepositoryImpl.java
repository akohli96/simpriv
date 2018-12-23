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

	private static final String selectQuery =  "select snippet.uuid as uuid, \n" +
			"snippet.message as message,\n" +
			"snippet.receiver as receiver_username,\n" +
			"receiver.password as receiver_password,\n" +
			"receiver.enabled as receiver_enabled,\n" +
			"receiver.role as receiver_role,\n" +
			"sender.role as sender_role,\n" +
			"sender.password as sender_password,\n" +
			"sender.enabled as sender_enabled,\n" +
			"snippet.sender as sender_username\n" +
			"from \n" +
			"snippet\n" +
			"inner join users receiver on snippet.receiver = receiver.username\n" +
			"inner join users sender on snippet.sender = sender.username\n" +
			"where \n" +
			"snippet.uuid  = ?";

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
