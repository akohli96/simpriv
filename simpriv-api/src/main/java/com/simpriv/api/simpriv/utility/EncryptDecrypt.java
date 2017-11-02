package com.simpriv.api.simpriv.utility;

import com.simpriv.api.simpriv.exception.SimPrivException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class EncryptDecrypt {

    private Cipher cipher;

    private static final String algorithm="RSA";


    public EncryptDecrypt() {
        try {
            init();
        } catch ( SimPrivException e ) {
            e.printStackTrace();
        }
    }

    private void init() throws SimPrivException {
        try {
            this.cipher = Cipher.getInstance(algorithm);
        } catch ( NoSuchAlgorithmException | NoSuchPaddingException e ) {
            throw new SimPrivException(e);
        }
    }

    public String encrypt(PublicKey publicKey, String plainText) throws SimPrivException {
        if(plainText.length()<1) {
            throw new SimPrivException("plainText is 0 character long");
        }
        else if(plainText == null){
            throw new SimPrivException("plainText is null");
        }
        else if(publicKey == null){
            throw new SimPrivException("public key is null");
        }
        try {
            this.cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            byte[] cipherText = this.cipher.doFinal(plainText.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | UnsupportedEncodingException e) {
            throw new SimPrivException(e);
        }
    }

    public  String decrypt(PrivateKey privateKey, String cipherText) throws SimPrivException {
        if(cipherText.length()<1) {
            throw new SimPrivException("cipherText is 0 character long");
        }
        else if(cipherText == null){
            throw new SimPrivException("cipherText is null");
        }
        try {
            this.cipher.init(Cipher.DECRYPT_MODE,privateKey);
            byte[] bytes = Base64.getDecoder().decode(cipherText);
            return new String(this.cipher.doFinal(bytes),"UTF-8");
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | UnsupportedEncodingException e) {
            throw new SimPrivException(e);
        }
    }
}
//https://gist.github.com/nielsutrecht/855f3bef0cf559d8d23e94e2aecd4ede