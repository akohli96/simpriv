package com.simpriv.api.simpriv.utility;

import com.simpriv.api.simpriv.exception.SimPrivException;
import org.junit.Before;
import org.junit.Test;

import java.security.Key;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class EncryptDecryptTest {

    private KeyRetrieval keyRetrieval;
    private EncryptDecrypt encryptDecrypt;
    private static final String secret="secret";
    private Key key;
    private static final String password ="password";

    @Before
    public void setUp() throws SimPrivException {
        keyRetrieval = mock(KeyRetrieval.class);
        encryptDecrypt = new EncryptDecrypt();
    }

    @Test
    public void decryptShouldReturnCorrectText() throws Exception {
        String cipher = encryptDecrypt.encrypt(secret,password);
        System.out.println(cipher);
        String plainText = encryptDecrypt.decrypt(cipher,password);
        assertEquals(secret,encryptDecrypt.decrypt(cipher,password));
    }


}