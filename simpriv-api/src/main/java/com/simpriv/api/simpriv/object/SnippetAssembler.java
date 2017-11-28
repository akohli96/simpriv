package com.simpriv.api.simpriv.object;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.simpriv.api.simpriv.exception.SimPrivException;
import com.simpriv.api.simpriv.service.UserService;
import com.simpriv.api.simpriv.utility.EncryptDecrypt;
import com.simpriv.api.simpriv.utility.Hasher;

@Component
public class SnippetAssembler {

	private EncryptDecrypt encryptDecrypt;
	private Hasher keyRetrieval;
	private UserService userService; //TODO : UserDAO
	
	@Inject
	public SnippetAssembler(EncryptDecrypt encryptDecrypt,Hasher keyRetrieval,UserService userService) {
		this.encryptDecrypt=encryptDecrypt;
		this.keyRetrieval=keyRetrieval;
		this.userService=userService;
	}
	
	public Snippet convertToEntity(SnippetDTO dto,String username) throws SimPrivException {
		try {
			String passwordHash = userService.getByUsername(username).getPassword();
			return new Snippet(encryptDecrypt.encrypt(dto.getMessage(),passwordHash),passwordHash);
		} catch (SimPrivException e) {
			throw new SimPrivException(e);
		}
	}
	
	public SnippetDTO convertToDTO(Snippet snippet, String password) throws SimPrivException {
		if(!keyRetrieval.hashString(password).equals(snippet.getHash())) {
			throw new SimPrivException("SnippetAssembler: Incorreect password for message ID " + snippet.getId());
		}
		try {
			return new SnippetDTO(encryptDecrypt.decrypt(snippet.getMessage(), snippet.getHash()));
		} catch (SimPrivException e) {
			throw new SimPrivException(e);
		}	
	}
}
