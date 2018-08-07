package com.simpriv.api.simpriv.domain.snippet;

import com.simpriv.api.simpriv.domain.snippet.Snippet;

public interface SnippetRepository {

	String createSnippet(Snippet snippet);

	Snippet getByID(String Id);
	
	void delete(String Id);
}
