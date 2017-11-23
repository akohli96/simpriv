package com.simpriv.api.simpriv.service;

import com.simpriv.api.simpriv.object.Snippet;

public interface SnippitService {

    Snippet getById(String id);

	String create(Snippet snippet);
}
