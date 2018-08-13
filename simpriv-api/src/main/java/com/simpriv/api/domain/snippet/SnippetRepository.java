package com.simpriv.api.domain.snippet;

public interface SnippetRepository {

	String createSnippet(Snippet snippet);

	Snippet getByID(String Id);
	
	void delete(String Id);
}
