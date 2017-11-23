package com.simpriv.api.simpriv.utility;

import com.simpriv.api.simpriv.exception.SimPrivException;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Base64;


@Component
public class EncryptDecrypt {

    private Cipher cipher;

    private static final String algorithm="AES";

    private KeyRetrieval keyRetrieval;

    //TODO :@Inject
    public EncryptDecrypt() throws SimPrivException {
    	Security.setProperty("crypto.policy", "unlimited");
        try {
            this.keyRetrieval=new KeyRetrieval();
            this.cipher = Cipher.getInstance(algorithm);
        } catch ( NoSuchAlgorithmException | NoSuchPaddingException e ) {
            throw new SimPrivException(e);
        }
    }


    public String encrypt(String plainText,String plainKey) throws SimPrivException {
        Key key = new SecretKeySpec(keyRetrieval.getHash(plainKey),"AES");
        if(plainText.length()<1) {
            throw new SimPrivException("plainText is 0 character long");
        } else {
		}
        try {
            this.cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] cipherText = this.cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
        	System.out.println(e.getMessage());
            throw new SimPrivException(e);
        }
    }

    public  String decrypt(String cipherText,String plainKey) throws SimPrivException {
        Key key = new SecretKeySpec(keyRetrieval.getHash(plainKey),"AES");
        try {
            this.cipher.init(Cipher.DECRYPT_MODE,key);
            byte[] bytes = Base64.getDecoder().decode(cipherText);
            return new String(this.cipher.doFinal(bytes),"UTF-8");
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | UnsupportedEncodingException e) {
            throw new SimPrivException(e);
        }
    }

}
