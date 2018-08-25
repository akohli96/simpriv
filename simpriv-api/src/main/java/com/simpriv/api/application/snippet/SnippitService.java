package com.simpriv.api.application.snippet;

import com.simpriv.api.domain.user.User;
import com.simpriv.api.port.primary.dto.SnippetCreateCommand;
import com.simpriv.api.port.primary.dto.SnippetDTO;

public interface SnippitService {

	SnippetDTO getByID(User unverifiedReceiver, String Id);

	String sendMessage(User sender, SnippetCreateCommand snippetCreateCommand);

}
