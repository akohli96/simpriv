package com.simpriv.api.simpriv.exception;

public class SimPrivException extends Exception{

    public SimPrivException(Throwable t){
        super(t);
    }

    public SimPrivException(String message) {
    	super(message);
    }
}
