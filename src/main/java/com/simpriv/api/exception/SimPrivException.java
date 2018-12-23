package com.simpriv.api.exception;

public class SimPrivException extends Exception{

    public SimPrivException(Throwable t){
        super(t);
    }

    public SimPrivException(String message) {
    	super(message);
    }
}
