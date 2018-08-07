package com.simpriv.api.simpriv.domain.snippet;

import com.simpriv.api.simpriv.domain.user.User;

public interface SnippitService {

    Snippet getById(String id);

	String create(Snippet snippet);

	String sendMessage(User from, User to, String message);
}
