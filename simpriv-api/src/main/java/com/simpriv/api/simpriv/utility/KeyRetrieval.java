package com.simpriv.api.simpriv.utility;

import com.simpriv.api.simpriv.exception.SimPrivException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class KeyRetrieval {

    private MessageDigest digest;
    private static final String algorithm="AES";
    private static final String hash="SHA-256";

    public KeyRetrieval() throws SimPrivException {
        try {
            this.digest=MessageDigest.getInstance(hash);
        } catch ( NoSuchAlgorithmException e ) {
            throw new SimPrivException(e);
        }
    }
    public String hashString(String text) throws  SimPrivException {
        if(text == null){
            throw new SimPrivException("Null text");
        }
        return Base64.getEncoder().encodeToString(digest.digest(text.getBytes(StandardCharsets.UTF_8)));
    }

    public byte[] getHash(String text) throws  SimPrivException {
        if(text == null){
            throw new SimPrivException("Null text");
        }
        return digest.digest(text.getBytes(StandardCharsets.UTF_8));
    }
}
