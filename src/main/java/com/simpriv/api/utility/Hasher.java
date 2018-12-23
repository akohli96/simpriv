package com.simpriv.api.utility;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class Hasher {

    private MessageDigest digest;
    private static final String hash="SHA-256";

    public Hasher() throws EncryptDecryptException {
        try {
            this.digest=MessageDigest.getInstance(hash);
        } catch ( NoSuchAlgorithmException e ) {
            throw new RuntimeException(e);
        }
    }
    public String hashString(String text) throws  EncryptDecryptException {
        return Base64.getEncoder().encodeToString(digest.digest(text.getBytes(StandardCharsets.UTF_8)));
    }

    public byte[] getHash(String text) throws  EncryptDecryptException {
        return digest.digest(text.getBytes(StandardCharsets.UTF_8));
    }
}
