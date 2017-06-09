package com.acmelogin.connector;

import com.google.gson.annotations.SerializedName;

/**
 * Object representation if user's Id Token.
 * @author Acme Developers
 *
 */
public class AcmeUserIdToken {

	private String jti;
	
	@SerializedName("iss")
	private String issuer;
	
	private String sub;
	
	@SerializedName("aud")
	private String clientId;
	
	@SerializedName("auth_time")
	private Long authTime;
	
	@SerializedName("session_state")
	private String sessionState;
	
	private Long iat;
	
	@SerializedName("exp")
	private Long expirationTime;
	
	private String email;
	@SerializedName("name")
	
	private String fullName;
	
	@SerializedName("preferred_username")
	private String username;
	
	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getSub() {
		return sub;
	}
	
	public void setSub(String sub) {
		this.sub = sub;
	}
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Long getIat() {
		return iat;
	}
	
	public void setIat(Long iat) {
		this.iat = iat;
	}
	
	public Long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Long expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getJti() {
		return jti;
	}
	
	public void setJti(String jti) {
		this.jti = jti;
	}
	
	public Long getAuthTime() {
		return authTime;
	}
	
	public void setAuthTime(Long authTime) {
		this.authTime = authTime;
	}
	
	public String getSessionState() {
		return sessionState;
	}
	
	public void setSessionState(String sessionState) {
		this.sessionState = sessionState;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString() {
		StringBuffer toString = new StringBuffer();
		toString.append("issuer: "+issuer+" | ");
		toString.append("sub: "+sub+" | ");
		toString.append("aud: "+clientId+" | ");
		toString.append("email: "+email+" | ");
		toString.append("iat: "+iat+" | ");
		toString.append("exp: "+expirationTime+" | ");
		toString.append("preferred username: "+username+" | ");
		toString.append("full name: "+fullName+" | ");
		return toString.toString();
	}
	
}
