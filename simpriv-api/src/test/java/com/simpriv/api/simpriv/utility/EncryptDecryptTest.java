package com.simpriv.api.simpriv.utility;

import org.junit.Before;
import org.junit.Test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EncryptDecryptTest {


    private static final String passwordString = "test";
    private static final String algorithm="RSA";
    private static final int keySize=1024;

    private EncryptDecrypt encryptDecrypt;
    private KeyPair keyPair;
    private KeyPairGenerator keyPairGenerator;

    @Before
    public void setUp() throws NoSuchAlgorithmException {
        keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        keyPairGenerator.initialize(keySize);
        keyPair = keyPairGenerator.generateKeyPair();
        encryptDecrypt = new EncryptDecrypt();
    }

    @Test
    public void encryptShouldReturnCorrectCipherText() throws Exception {
        String resultString = encryptDecrypt.encrypt(keyPair.getPublic(),passwordString);
        assertNotEquals(resultString,passwordString);
    }

    @Test
    public void decryptShouldReturnCorrectPlainText() throws Exception {
            String resultString = encryptDecrypt.encrypt(keyPair.getPublic(), passwordString);
            assertEquals(passwordString, encryptDecrypt.decrypt(keyPair.getPrivate(), resultString));
    }

//    @Test
//    public void decryptShouldReturnsCorrectPlainText() throws Exception {
//        String resultString = encryptDecrypt.encrypt(keyPair.getPublic(), null);
//        assertEquals(passwordString, encryptDecrypt.decrypt(keyPair.getPrivate(), resultString));
//    }
}