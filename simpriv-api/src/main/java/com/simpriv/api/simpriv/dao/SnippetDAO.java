package com.simpriv.api.simpriv.dao;

import com.simpriv.api.simpriv.object.Snippet;

public interface SnippetDAO {

	String createSnippet(Snippet snippet);

	Snippet getById(String Id);
}
