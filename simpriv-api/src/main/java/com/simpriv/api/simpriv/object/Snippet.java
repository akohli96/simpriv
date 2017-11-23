package com.simpriv.api.simpriv.object;

import java.util.UUID;

public class Snippet {

	private String id;
    private String message;
    private String hash;
    
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
