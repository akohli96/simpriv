package com.simpriv.api.application.snippet;

import com.simpriv.api.application.user.UserService;
import com.simpriv.api.domain.snippet.Snippet;
import com.simpriv.api.domain.snippet.SnippetException;
import com.simpriv.api.domain.snippet.SnippetRepository;
import com.simpriv.api.domain.user.User;
import com.simpriv.api.domain.user.UserRepository;
import com.simpriv.api.port.primary.dto.SnippetCreateCommand;
import com.simpriv.api.port.primary.dto.SnippetDTO;
import com.simpriv.api.utility.EncryptDecrypt;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.UUID;

@Component
public class SnippitServiceImpl implements SnippitService {

	private SnippetRepository snippetRepository;
	private EncryptDecrypt encryptDecrypt;
	private UserService userService;
	
    @Inject
    public SnippitServiceImpl(SnippetRepository snippetRepository,EncryptDecrypt encryptDecrypt, UserService userService){
    	this.snippetRepository=snippetRepository;
    	this.encryptDecrypt=encryptDecrypt;
    	this.userService=userService;
    }

    private String createSnippet(Snippet snippet) {
        return snippetRepository.createSnippet(snippet);
    }

    @Override
    public SnippetDTO getByID(User unverifiedReceiver, String Id) {
        Snippet snippet = snippetRepository.getByID(Id);
        snippet.decrypt(unverifiedReceiver,encryptDecrypt);
        delete(Id); //business logic
        return snippet.toDTO();
    }

    @Override
    public String sendMessage(User sender, SnippetCreateCommand snippetCreateCommand) {
        User receiver = userService.getByUsername(snippetCreateCommand.getReceiver());
        Snippet newSnippet = new Snippet(sender,receiver, snippetCreateCommand.getMessage(), UUID.randomUUID().toString());
        return createSnippet(newSnippet);
    }


    private void delete(String Id) {
        snippetRepository.delete(Id);
    }

}
