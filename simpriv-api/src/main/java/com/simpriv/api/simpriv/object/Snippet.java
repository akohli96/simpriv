package com.simpriv.api.simpriv.object;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Snippet {

    private String id;
    private String message;
    private String hash;

    @JsonCreator
    public Snippet(@JsonProperty("message") String message){
        this.id= UUID.randomUUID().toString();
        this.message=message;
    }

    public void setHash(String hash){
        this.hash=hash;
    }

    public String getId() {
        return id;
    }

    @JsonIgnore
    public String getMessage() {
        return message;
    }

    @JsonIgnore
    public String getHash() {
        return hash;
    }
}
