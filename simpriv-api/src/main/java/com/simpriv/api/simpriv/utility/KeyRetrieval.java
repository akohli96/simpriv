package com.simpriv.api.simpriv.utility;

import com.simpriv.api.simpriv.exception.SimPrivException;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
    public Key retriveKeyFromString(String text) throws  SimPrivException {
        if(text == null){
            throw new SimPrivException("Null key");
        }
        final byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        return new SecretKeySpec(hash,algorithm);
    }
}
