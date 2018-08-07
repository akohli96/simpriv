package com.simpriv.api.simpriv.domain.snippet.service;

import com.simpriv.api.simpriv.domain.snippet.SnippetRepository;
import com.simpriv.api.simpriv.domain.user.User;
import com.simpriv.api.simpriv.domain.snippet.Snippet;
import com.simpriv.api.simpriv.domain.snippet.SnippitService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class SnippitServiceImpl implements SnippitService {

	private SnippetRepository snippetRepository;
	
    @Inject
    public SnippitServiceImpl(SnippetRepository snippetDao){
    	this.snippetRepository=snippetRepository;
    }
    
    @Override
    public Snippet getById(String id) {
        return snippetRepository.getByID(id);
    }

	@Override
	public String create(Snippet snippet) {
		return snippetRepository.createSnippet(snippet);
	}

    @Override
    public String sendMessage(User from, User to, String message) {
        Snippet newSnippet = new Snippet(from,to,message);
        newSnippet.encrypt();
        return create(newSnippet);
    }
}
