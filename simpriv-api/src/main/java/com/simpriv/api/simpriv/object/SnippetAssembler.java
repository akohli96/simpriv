package com.simpriv.api.simpriv.object;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.simpriv.api.simpriv.exception.SimPrivException;
import com.simpriv.api.simpriv.utility.EncryptDecrypt;
import com.simpriv.api.simpriv.utility.KeyRetrieval;

@Component
public class SnippetAssembler {

	private EncryptDecrypt encryptDecrypt;
	//private KeyRetrieval keyRetrieval;
	
	@Inject
	public SnippetAssembler(EncryptDecrypt encryptDecrypt,KeyRetrieval keyRetrieval) {
		this.encryptDecrypt=encryptDecrypt;
		//this.keyRetrieval=keyRetrieval;
	}
	
	//TODO : encrypt with recievers usersname password instead of for time being encrypt with recievers username
	public Snippet convertToEntity(SnippetDTO dto,String username) throws SimPrivException {
		try {
			return new Snippet(encryptDecrypt.encrypt(dto.getMessage(),username),username);
		} catch (SimPrivException e) {
			throw new SimPrivException(e);
		}
	}
	
	public SnippetDTO convertToDTO(Snippet snippet, String password) throws SimPrivException {
//		log.info(keyRetrieval.hashString(password));
//		log.info(snippet.getHash());
//		if(!keyRetrieval.hashString(password).equals(snippet.getHash())) {
//			throw new SimPrivException("SnippetAssembler: Incorreect password for message ID " + snippet.getId());
//		}
		try {
			return new SnippetDTO(encryptDecrypt.decrypt(snippet.getMessage(), password));
		} catch (SimPrivException e) {
			throw new SimPrivException(e);
		}	
	}
}
