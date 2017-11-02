package com.simpriv.api.simpriv.utility;

import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

@Component
public class PairGenerator {

    private KeyPairGenerator keyPairGenerator;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public KeyPairGenerator(){

    }

    private void initializeKeyGen(){
        this.keyPairGenerator = KeyPairGenerator.
    }
    public KeyPair generatorKeyPair(){
        KeyPair pair =
    }

}
