package com.simpriv.api.application.snippet;

import com.simpriv.api.domain.snippet.Snippet;
import com.simpriv.api.domain.user.User;

public interface SnippitService {

	String sendMessage(User sender, User receiver, String message);

	Snippet getByID(User unverifiedReceiver, String Id);

}
