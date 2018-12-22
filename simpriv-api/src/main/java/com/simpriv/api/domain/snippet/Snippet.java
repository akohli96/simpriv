package com.simpriv.api.domain.snippet;

import com.simpriv.api.domain.user.User;
import com.simpriv.api.port.primary.dto.SnippetCreateCommand;
import com.simpriv.api.port.primary.dto.SnippetDTO;
import com.simpriv.api.utility.EncryptDecryptException;
import com.simpriv.api.utility.EncryptDecrypt;

import java.util.UUID;

public class Snippet {

	private String id;
    private String message;
    private User sender;
    private User receiver;

    public Snippet(User sender, User receiver, String message,String Id){
        this.sender=sender;
        this.receiver=receiver;
        this.message=message;
        this.id=Id;
    }

    public static Snippet sendMessageSnippetEntity(User sender, User receiver, SnippetCreateCommand createCommand){
        return new Snippet(sender,receiver, createCommand.getMessage(), UUID.randomUUID().toString());
    }

    public Snippet encrypt(EncryptDecrypt encryptDecrypt){
        try {
            this.message=encryptDecrypt.encrypt(this.message,receiver.getPassword());
        } catch (SnippetException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Snippet decrypt(User unverifiedReceiver,EncryptDecrypt encryptDecrypt){
        if(!this.receiver.getName().equals(unverifiedReceiver.getName())){
            throw new SnippetException("Incorrect Name");
        }
        if(!this.receiver.getPassword().equals(unverifiedReceiver.getPassword())){
            throw new SnippetException("Incorrect Password");
        }

        try {
            this.message=encryptDecrypt.decrypt(message,unverifiedReceiver.getPassword());
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

    public User getSender(){
        return this.sender;
    }

    public User getReceiver(){
        return this.receiver;
    }

    public SnippetDTO toDTO(){
        return new SnippetDTO(this.message);
    }
}
