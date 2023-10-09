package com.mj.utility;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Authorizer {
	
	public static String getMd5(String input){
		
        try {
             MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            byte[] messageDigestArray = messageDigest.digest(input.getBytes());
 
            BigInteger no = new BigInteger(1, messageDigestArray);
 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        
        }catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	public static String getEncryptedData(String stringToBeEncrypted) {
		
		 byte[] keyBytes = "KeyForEncryption".getBytes();
		 Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		 SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
		 cipher.init(Cipher.ENCRYPT_MODE, key);
		 byte[] cipherText = cipher.doFinal(stringToBeEncrypted.getBytes(StandardCharsets.UTF_8));
		 String encodedTxt = Base64.encodeBase64URLSafeString(cipherText);
		 
		 return encodedTxt;
	}
	
	public static String getDecrypteddata(String stringTobeDerypted) {
		
	}
	
}
