package com.simpriv.api.domain.snippet;

public class SnippetException extends  RuntimeException{

    public SnippetException(Throwable t){
        super(t);
    }

    public SnippetException(String message) {
        super(message);
    }

}
