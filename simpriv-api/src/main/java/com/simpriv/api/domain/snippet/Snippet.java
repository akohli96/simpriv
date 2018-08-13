package com.simpriv.api.domain.snippet;

import com.simpriv.api.domain.user.User;
import com.simpriv.api.utility.EncryptDecryptException;
import com.simpriv.api.utility.EncryptDecrypt;

import java.util.UUID;

public class Snippet {

	private String id;
    private String message;
    private String hash;
    private User sender;
    private User receiver;
    private EncryptDecrypt encryptDecrypt;

    public Snippet(User sender, User receiver, String message,String Id){
        this.sender=sender;
        this.receiver=receiver;
        this.message=message;
        this.id=Id;
    }

    public Snippet(User sender, User receiver, String message){
        this.sender=sender;
        this.receiver=receiver;
        this.message=message;
        this.id=UUID.randomUUID().toString();
    }

    public Snippet encrypt(){
        try {
            this.message=encryptDecrypt.encrypt(this.message,receiver.getPassword());
        } catch (SnippetException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Snippet decrypt(User unverifiedReceiver){
        if(!this.receiver.getName().equals(unverifiedReceiver.getName())){
            throw new SnippetException("Incorrect Name");
        }
        if(!this.receiver.getPassword().equals(unverifiedReceiver.getPassword())){
            throw new SnippetException("Incorrect Password");
        }

        try {
            encryptDecrypt.decrypt(message,unverifiedReceiver.getPassword());
        } catch (EncryptDecryptException e) {
            e.printStackTrace();
        }
        return this;
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

    public User getSender(){
        return this.sender;
    }

    public User getReceiver(){
        return this.receiver;
    }
}
