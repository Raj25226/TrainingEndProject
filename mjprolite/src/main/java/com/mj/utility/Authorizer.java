package com.mj.utility;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Authorizer {
	
	public static Cipher cipher;
	
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
		
		byte[] keyBytes = AppConstant.CIPHER_KEY.getBytes();
		String encodedTxt="COULD NOT ENCRYPT";
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] cipherText = cipher.doFinal(stringToBeEncrypted.getBytes(StandardCharsets.UTF_8));
			encodedTxt = Base64.encodeBase64URLSafeString(cipherText);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		return encodedTxt;
	}
	
	public static String getDecrypteddata(String stringTobeDerypted) {
		
		byte[] keyBytes = AppConstant.CIPHER_KEY.getBytes();
		SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
		String decodeStr;
		byte[] decryptedPassword=null;
		try {
			decryptedPassword = "COULD NOT DECRYPT".getBytes("UTF-16");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  ;
		
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			decodeStr = URLDecoder.decode(stringTobeDerypted,StandardCharsets.UTF_8.toString());
			byte[] base64decodedTokenArr = Base64.decodeBase64(decodeStr.getBytes(StandardCharsets.UTF_8));
			decryptedPassword = cipher.doFinal(base64decodedTokenArr);
		} catch (UnsupportedEncodingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		
		return new String(decryptedPassword);
	}
	
}
