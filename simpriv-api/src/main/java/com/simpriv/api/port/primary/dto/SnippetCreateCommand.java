package com.simpriv.api.port.primary.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SnippetCreateCommand {
	
	private String message;
	
    @JsonCreator
    public SnippetCreateCommand(@JsonProperty("message") String message){
        this.message=message;
    }
    
    public String getMessage() {
    	return this.message;
    }
}
