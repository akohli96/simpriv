package com.simpriv.api.port.primary.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SnippetDTO {
	
	private String message;
	
    @JsonCreator
    public SnippetDTO(@JsonProperty("message") String message){
        this.message=message;
    }
    
    public String getMessage() {
    	return this.message;
    }
}
