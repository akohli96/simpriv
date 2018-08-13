package com.simpriv.api.utility;

import com.simpriv.api.exception.SimPrivException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class Hasher {

    private MessageDigest digest;
    private static final String hash="SHA-256";

    public Hasher() throws EncryptDecryptException {
        try {
            this.digest=MessageDigest.getInstance(hash);
        } catch ( NoSuchAlgorithmException e ) { //TODO: Just throw this instead
            throw new EncryptDecryptException(e);
        }
    }
    public String hashString(String text) throws  EncryptDecryptException {
        if(text == null){
            throw new EncryptDecryptException("Null text");
        }
        return Base64.getEncoder().encodeToString(digest.digest(text.getBytes(StandardCharsets.UTF_8)));
    }

    public byte[] getHash(String text) throws  EncryptDecryptException {
        if(text == null){
            throw new EncryptDecryptException("Null text");
        }
        return digest.digest(text.getBytes(StandardCharsets.UTF_8));
    }
}
