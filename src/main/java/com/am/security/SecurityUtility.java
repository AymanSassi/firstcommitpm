package com.am.security;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtility {
	
	private static String JWT_SECRET=Base64.getEncoder().encodeToString("efkldkjfilmdmdsk+".getBytes()); //Salt should be protected carefully
	
	//Pour production
	//static String JWT_SECRET_RANDOM=randomPassword();

	//Pour developpement
	static String JWT_SECRET_RANDOM="1919SKSSJS?S?SLZ";
		
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12, new SecureRandom(JWT_SECRET.getBytes()));
	}
	
	private static String randomPassword() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		
		while(salt.length() < 30) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		
		String saltStr = salt.toString();
		return saltStr;
	}
}
