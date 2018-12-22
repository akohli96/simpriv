package com.simpriv.api.application.snippet;

import com.simpriv.api.domain.snippet.Snippet;
import com.simpriv.api.domain.snippet.SnippetRepository;
import com.simpriv.api.domain.snippet.SnippetService;
import com.simpriv.api.domain.user.custom.CustomUserPrincipal;
import com.simpriv.api.domain.user.User;
import com.simpriv.api.domain.user.UserRepository;
import com.simpriv.api.port.primary.dto.SnippetCreateCommand;
import com.simpriv.api.port.primary.dto.SnippetDTO;
import com.simpriv.api.utility.EncryptDecrypt;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SnipperServiceImpl implements SnippetService {

    private SnippetRepository snippetRepository;
    private EncryptDecrypt encryptDecrypt;
    private UserRepository userRepository;

    @Inject
    public SnipperServiceImpl(SnippetRepository snippetRepository, EncryptDecrypt encryptDecrypt, UserRepository userRepository) {
        this.snippetRepository = snippetRepository;
        this.encryptDecrypt = encryptDecrypt;
        this.userRepository = userRepository;
    }

    @Override
    public SnippetDTO getByID(CustomUserPrincipal unverifiedReceiver, String id) {
        Snippet snippet = snippetRepository.getByID(id);
        snippet.decrypt(unverifiedReceiver.getUser(),encryptDecrypt);
        snippetRepository.delete(id);
        return snippet.toDTO();
    }

    @Override
    public String sendMessage(CustomUserPrincipal sender, SnippetCreateCommand snippetCreateCommand) {
        User receiver = userRepository.getByUsername(snippetCreateCommand.getReceiver());
        Snippet newSnippet = Snippet.sendMessageSnippetEntity(sender.getUser(),receiver,snippetCreateCommand);
        newSnippet.encrypt(encryptDecrypt);
        return snippetRepository.createSnippet(newSnippet);
    }
}
