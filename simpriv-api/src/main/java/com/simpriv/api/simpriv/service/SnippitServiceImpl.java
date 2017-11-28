package com.simpriv.api.simpriv.service;

import com.simpriv.api.simpriv.dao.SnippetDAO;
import com.simpriv.api.simpriv.object.Snippet;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class SnippitServiceImpl implements  SnippitService{

	private SnippetDAO snippetDao;
	
    @Inject
    public SnippitServiceImpl(SnippetDAO snippetDao){
    	this.snippetDao=snippetDao;
    }
    
    @Override
    public Snippet getById(String id) {
        return snippetDao.getByID(id);
    }

	@Override
	public String create(Snippet snippet) {
		return snippetDao.createSnippet(snippet);
	}
}
