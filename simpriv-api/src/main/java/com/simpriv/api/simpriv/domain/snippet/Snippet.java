package com.simpriv.api.simpriv.domain.snippet;

import com.simpriv.api.simpriv.domain.user.User;
import com.simpriv.api.simpriv.exception.SimPrivException;
import com.simpriv.api.simpriv.utility.EncryptDecrypt;

import java.util.UUID;

public class Snippet {

	private String id;
    private String message;
    private String hash;
    private User sender;
    private User receiver;
    private EncryptDecrypt encryptDecrypt;

    public Snippet(User sender, User receiver, String message){
        this.sender=sender;
        this.receiver=receiver;
        this.message=message;
        this.id=UUID.randomUUID().toString();
    }

    public Snippet encrypt(){
        try {
            this.message=encryptDecrypt.encrypt(this.message,receiver.getPassword());
        } catch (SimPrivException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Snippet decrypt(User unverifiedReceiver){
        if(!this.receiver.getName().equals(unverifiedReceiver.getName())){
            throw new RuntimeException("Incorrect Name");
        }
        if(!this.receiver.getPassword().equals(unverifiedReceiver.getPassword())){
            throw new RuntimeException("Incorrect Password");
        }

        try {
            encryptDecrypt.decrypt(message,unverifiedReceiver.getPassword());
        } catch (SimPrivException e) {
            e.printStackTrace();
        }
        return this;
    }
    
    public Snippet(String message,String hash){
        this.id= UUID.randomUUID().toString();
        this.message=message;
        this.hash=hash;
    }

    public Snippet(String id, String message, String hash) {
		this.id = id;
		this.message = message;
		this.hash = hash;
	}
    
    public String getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public String getHash() {
        return this.hash;
    }
}
