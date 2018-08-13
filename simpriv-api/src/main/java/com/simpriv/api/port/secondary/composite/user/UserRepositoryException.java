package com.simpriv.api.port.secondary.composite.user;

public class UserRepositoryException extends RuntimeException {

    public UserRepositoryException(Throwable t){
        super(t);
    }

    public UserRepositoryException(String message) {
        super(message);
    }

}
