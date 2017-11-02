package com.simpriv.api.simpriv.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.*;
import java.security.spec.AlgorithmParameterSpec;

@Configuration
public class ApplicationConfig{

    @Bean
    public KeyPairGenerator keyPairGenerator() throws NoSuchAlgorithmException {
        final String algorithm="RSA";
        KeyPairGenerator keyPairGenerator = new KeyPairGenerator(algorithm) {
            @Override
            public String getAlgorithm() {
                return super.getAlgorithm();
            }

            @Override
            public void initialize(int i) {
                super.initialize(i);
            }

            @Override
            public void initialize(int i, SecureRandom secureRandom) {
                super.initialize(i, secureRandom);
            }

            @Override
            public void initialize(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
                super.initialize(algorithmParameterSpec);
            }

            @Override
            public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
                super.initialize(algorithmParameterSpec, secureRandom);
            }

            @Override
            public KeyPair generateKeyPair() {
                return super.generateKeyPair();
            }
        };
        keyPairGenerator.initialize(1024);
        return keyPairGenerator;
    }
}