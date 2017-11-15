package com.simpriv.api.simpriv.service;

import com.simpriv.api.simpriv.exception.SimPrivException;
import com.simpriv.api.simpriv.object.Snippet;
import com.simpriv.api.simpriv.utility.EncryptDecrypt;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class SnippitServiceImpl implements  SnippitService{

    private EncryptDecrypt encryptDecrypt;

    //inject UserDAO,SnippitDAO
    @Inject
    public SnippitServiceImpl(EncryptDecrypt encryptDecrypt){
        this.encryptDecrypt=encryptDecrypt;
    }

    @Override
    public Snippet create(String password, String recieversUsername, Snippet snippet) throws SimPrivException {
        //Make call to UserRepository to verify if password and recieversUsername are both valid
        try {
            //store in dao,with id
            snippet.setHash(recieversUsername);
            System.out.println(snippet.getId() + " " + snippet.getMessage() + " " + snippet.getHash() );
            System.out.println(encryptDecrypt.encrypt(snippet.getMessage(),recieversUsername));
            return snippet;
        } catch ( SimPrivException e ) {
            throw new SimPrivException(e);
        }
    }

    @Override
    public Snippet getById(String id) {
        return null;
    }
}
