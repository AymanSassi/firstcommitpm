package com.am.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.am.entity.Tuser;
import com.am.entity.Tusersignin;
import com.am.repository.UsersigninRepository;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {

	private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
	@Autowired
	UsersigninRepository usersigninRepository;

	@Value("${com.am.security.jwtExpiration}")
	private int jwtExpiration;

	public String generateJwtToken(Authentication authentication) {
		Tuser userPrincipal = (Tuser) authentication.getPrincipal();
		String s = Jwts.builder()
				.setSubject(new Long(userPrincipal.getIduser()).toString() + "," + userPrincipal.getUsername())
				.setIssuedAt(new Date()).setExpiration(new Date((new Date()).getTime() + jwtExpiration * 1000))
				.signWith(SignatureAlgorithm.HS512, SecurityUtility.JWT_SECRET_RANDOM).compact();

		return s;
	}

	public boolean validateJwtToken(String authToken) {
		try {
			//System.out.println("phase 0");
			Jwts.parser().setSigningKey(SecurityUtility.JWT_SECRET_RANDOM).parseClaimsJws(authToken);
			//System.out.println("phase 1");
			Tusersignin tusersignin = usersigninRepository.findByToken(authToken);
			//System.out.println("phase 2");
			if (tusersignin != null)
				return true;
			else
				logger.error("Unsupported JWT token -> Message: {}");
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature -> Message: {} ", e);
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token -> Message: {}", e);
		} catch (ExpiredJwtException e) {
			logger.error("Expired JWT token -> Message: {}", e);
		} catch (UnsupportedJwtException e) {
			logger.error("Unsupported JWT token -> Message: {}", e);
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty -> Message: {}", e);
		}

		//System.out.println("fin with error");
		return false;
	}

	public long getIdUserFromJwtToken(String token) {
		String subject = Jwts.parser().setSigningKey(SecurityUtility.JWT_SECRET_RANDOM).parseClaimsJws(token).getBody()
				.getSubject();
		return new Long(subject.substring(0, subject.indexOf(",") - 1)).longValue();
	}

	public String getUserNameFromJwtToken(String token) {
		String subject = Jwts.parser().setSigningKey(SecurityUtility.JWT_SECRET_RANDOM).parseClaimsJws(token).getBody()
				.getSubject();
		return subject.substring(subject.indexOf(",") + 1);
	}
}