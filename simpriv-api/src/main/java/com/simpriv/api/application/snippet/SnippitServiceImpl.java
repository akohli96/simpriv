package com.simpriv.api.application.snippet;

import com.simpriv.api.domain.snippet.Snippet;
import com.simpriv.api.domain.snippet.SnippetRepository;
import com.simpriv.api.domain.user.User;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.UUID;

@Component
public class SnippitServiceImpl implements SnippitService {

	private SnippetRepository snippetRepository;
	
    @Inject
    public SnippitServiceImpl(SnippetRepository snippetRepository){
    	this.snippetRepository=snippetRepository;
    }

    @Override
    public String sendMessage(User sender, User receiver, String message) {
        Snippet newSnippet = new Snippet(sender,receiver,message, UUID.randomUUID().toString());
        newSnippet.encrypt();
        return createSnippet(newSnippet);
    }


    private String createSnippet(Snippet snippet) {
        return snippetRepository.createSnippet(snippet);
    }

    @Override
    public Snippet getByID(User unverifiedReceiver,String Id) {
        Snippet snippet = snippetRepository.getByID(Id);
        snippet.decrypt(unverifiedReceiver);
        delete(Id);
        return snippet;
    }

    private void delete(String Id) {
        snippetRepository.delete(Id);
    }

}
