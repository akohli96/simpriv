package com.simpriv.api.simpriv.utility;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

@Component
public class PairGenerator {

    private KeyPairGenerator keyPairGenerator;

    @Inject
    public PairGenerator(KeyPairGenerator keyPairGenerator)  {
        this.keyPairGenerator=keyPairGenerator;
    }

    public KeyPair generatorKeyPair() {
        return keyPairGenerator.generateKeyPair();
    }

}
