package com.simpriv.api.simpriv.utility;

import com.simpriv.api.simpriv.exception.SimPrivException;
import org.junit.Before;
import org.junit.Test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PairGeneratorTest {

    private PairGenerator pairGenerator;
    private KeyPairGenerator keyPairGenerator;

    @Before
    public void setUp() throws SimPrivException {
        keyPairGenerator = mock(KeyPairGenerator.class);
        pairGenerator = new PairGenerator(keyPairGenerator);
    }

    @Test
    public void generatorKeyPairShouldCreateKeyPair() throws SimPrivException, NoSuchAlgorithmException {
        KeyPair testKeyPair = new KeyPair(mock(RSAPublicKey.class), mock(RSAPrivateKey.class));
        when(keyPairGenerator.generateKeyPair()).thenReturn(testKeyPair);
        KeyPair keyPair = pairGenerator.generatorKeyPair();
        assertNotNull(keyPair);
        assertTrue(keyPair.getPublic() != null);
        assertTrue(keyPair.getPrivate() != null);
    }

//    @Test(expected = SimPrivException.class)
//    public void generateKeyPairThrowsNoSuchAlgorithmException() throws SimPrivException {
//        KeyPairGenerator keypairGen = mock(KeyPairGenerator.class);
//        doThrow(NoSuchAlgorithmException.class).when(keypairGen).initialize(anyInt());
//        pairGenerator = new PairGenerator(keypairGen);
//    }

//    @Test()
//    public void generateKeyPaisrThrowsNoSuchAlgorithmException() throws NoSuchAlgorithmException, SimPrivException {
//        pairGenerator = new PairGenerator(null);
//        KeyPair keyPair = pairGenerator.generatorKeyPair();
//    }

}

//https://gist.github.com/dmydlarz/32c58f537bb7e0ab9ebf