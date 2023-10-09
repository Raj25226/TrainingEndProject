package com.mj.utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	
	
	
}
