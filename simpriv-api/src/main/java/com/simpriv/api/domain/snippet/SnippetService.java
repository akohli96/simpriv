package com.simpriv.api.domain.snippet;

import com.simpriv.api.domain.user.custom.CustomUserPrincipal;
import com.simpriv.api.port.primary.dto.SnippetCreateCommand;
import com.simpriv.api.port.primary.dto.SnippetDTO;

public interface SnippetService {
    SnippetDTO getByID(CustomUserPrincipal unverifiedReceiver, String id);

    String sendMessage(CustomUserPrincipal sender, SnippetCreateCommand snippetCreateCommand);
}
