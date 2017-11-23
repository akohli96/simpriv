package com.simpriv.api.simpriv.object;

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
