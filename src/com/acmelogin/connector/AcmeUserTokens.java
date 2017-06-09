package com.acmelogin.connector;

import com.google.gson.annotations.SerializedName;

public class AcmeUserTokens {

	@SerializedName("access_token")
	private String accessToken;
	
	@SerializedName("expires_in")
	private Long accessTokenExpiresIn;
	
	@SerializedName("refresh_token")
	private String refreshToken;
	
	@SerializedName("refresh_expires_in")
	private Long refreshTokenExpiresIn;
	
	@SerializedName("session_state")
	private String sessionState;
	
	@SerializedName("id_token")
	private String idToken;
	
	private transient AcmeUserIdToken acmeUserIdToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public AcmeUserIdToken getAcmeUserIdToken() {
		return acmeUserIdToken;
	}

	public void setAcmeUserIdToken(AcmeUserIdToken acmeUserIdToken) {
		this.acmeUserIdToken = acmeUserIdToken;
	}

	public Long getAccessTokenExpiresIn() {
		return accessTokenExpiresIn;
	}

	public void setAccessTokenExpiresIn(Long accessTokenExpiresIn) {
		this.accessTokenExpiresIn = accessTokenExpiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Long getRefreshTokenExpiresIn() {
		return refreshTokenExpiresIn;
	}

	public void setRefreshTokenExpiresIn(Long refreshTokenExpiresIn) {
		this.refreshTokenExpiresIn = refreshTokenExpiresIn;
	}

	public String getSessionState() {
		return sessionState;
	}

	public void setSessionState(String sessionState) {
		this.sessionState = sessionState;
	}

	public String getIdToken() {
		return idToken;
	}

	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}
	
}
