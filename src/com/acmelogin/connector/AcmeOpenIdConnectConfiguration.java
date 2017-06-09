package com.acmelogin.connector;

/**
 * 
 * @author Acme Developers
 *
 */
public class AcmeOpenIdConnectConfiguration {

	private String redirectUrl;
	
	private String acmeServerUrl;
	
	private String acmeTokenEndPointPath;
	
	private String acmeUserinfoEndPointPath;
	
	private String acmeEndSessionEndPointPath;
	
	private String clientId;
	
	private String clientSecret;
	
	private String expectedIssuer;
	
	private String logoutRedirectUrl;

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getAcmeServerUrl() {
		return acmeServerUrl;
	}

	public void setAcmeServerUrl(String acmeServerUrl) {
		this.acmeServerUrl = acmeServerUrl;
	}

	public String getAcmeTokenEndPointPath() {
		return acmeTokenEndPointPath;
	}

	public void setAcmeTokenEndPointPath(String acmeTokenEndPointPath) {
		this.acmeTokenEndPointPath = acmeTokenEndPointPath;
	}

	public String getAcmeUserinfoEndPointPath() {
		return acmeUserinfoEndPointPath;
	}

	public void setAcmeUserinfoEndPointPath(String acmeUserinfoEndPointPath) {
		this.acmeUserinfoEndPointPath = acmeUserinfoEndPointPath;
	}

	public String getAcmeEndSessionEndPointPath() {
		return acmeEndSessionEndPointPath;
	}

	public void setAcmeEndSessionEndPointPath(String acmeEndSessionEndPointPath) {
		this.acmeEndSessionEndPointPath = acmeEndSessionEndPointPath;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getExpectedIssuer() {
		return expectedIssuer;
	}

	public void setExpectedIssuer(String expectedIssuer) {
		this.expectedIssuer = expectedIssuer;
	}

	public String getLogoutRedirectUrl() {
		return logoutRedirectUrl;
	}

	public void setLogoutRedirectUrl(String logoutRedirectUrl) {
		this.logoutRedirectUrl = logoutRedirectUrl;
	}
	
	
}
