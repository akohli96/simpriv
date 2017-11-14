package com.simpriv.api.simpriv.utility;

import com.simpriv.api.simpriv.exception.SimPrivException;
import org.junit.Before;
import org.junit.Test;

import java.security.Key;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KeyRetrievalTest {
    private static final String message="Message";
    private KeyRetrieval keyRetrieval;

    @Before
    public void setUp() throws SimPrivException {
        keyRetrieval = new KeyRetrieval();
    }

    @Test
    public void sameInputShouldReturnSameKeys() throws Exception {
        Key key = keyRetrieval.retriveKeyFromString(message);
        Key keyToTest = keyRetrieval.retriveKeyFromString(message);
        assertTrue(Arrays.equals(key.getEncoded(),keyToTest.getEncoded()));
    }

    @Test
    public void differentInputShouldReturnSameKeys() throws Exception {
        Key key = keyRetrieval.retriveKeyFromString("anotherMessage");
        Key keyToTest = keyRetrieval.retriveKeyFromString(message);
        assertFalse(Arrays.equals(key.getEncoded(),keyToTest.getEncoded()));
    }

    @Test(expected = SimPrivException.class)
    public void keyRetrivalShouldThrowSimPrivException() throws SimPrivException {
        Key key = keyRetrieval.retriveKeyFromString(null);
    }
}