package com.simpriv.api.domain.snippet;

import com.simpriv.api.domain.user.User;
import com.simpriv.api.port.primary.dto.SnippetCreateCommand;
import com.simpriv.api.port.primary.dto.SnippetDTO;

public interface SnippetService {
    SnippetDTO getByID(User unverifiedReceiver, String id);

    String sendMessage(User sender, SnippetCreateCommand snippetCreateCommand);
}
