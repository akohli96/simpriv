package com.simpriv.api.utility;

public class EncryptDecryptException extends  RuntimeException{

    public EncryptDecryptException(Throwable t){
        super(t);
    }

    public EncryptDecryptException(String message) {
        super(message);
    }

}
