package com.acmelogin.connector;


/**
 * 
 * @author Acme Developers
 *
 */
public class AcmeOpenIdConnectValidator {

	/*
	 * Validates authorization step for Acme Login OpenID Connect protocol. 'authorizationCode' and 'state' shouldn't be empty, 'state' should have same value with 'clientGeneratedState'.
	 * 'state' is option. So if you don't want this validation in this step, you should just check if 'authorizationCode' has a value. 
	 */
	public boolean validateAuthorization(final String authorizationCode, final String state, final String clientGeneratedState) {
		if(state == null || clientGeneratedState == null || authorizationCode == null) {
			return false;
		}
		
		if(!state.equals(clientGeneratedState)) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * Validates Acme Login user's Id Token that received during authentication flow.
	 * This can be called anytime before using an Id Token.
	 */
	public boolean validateIdToken(final AcmeUserIdToken acmeIdToken, final AcmeOpenIdConnectConfiguration acmeOpenIdConnectConfiguration) {
		if(acmeIdToken == null) {
			return false;
		}
		
		/*
		 * 'issuer' should be same with expected issuer that configured.
		 */
		if(!acmeIdToken.getIssuer().equals(acmeOpenIdConnectConfiguration.getExpectedIssuer())) {
			System.out.println("Id token issuer not matched. Expected issuer: "+acmeOpenIdConnectConfiguration.getExpectedIssuer()+" , Received issuer: "+acmeIdToken.getIssuer());
			return false;
		}
		
		/*
		 * 'clientId' should be same with clientId of the app that configured.
		 */
		if(!acmeIdToken.getClientId().equals(acmeOpenIdConnectConfiguration.getClientId())) {
			System.out.println("Id token clientId not matched. Expected clientId: "+acmeOpenIdConnectConfiguration.getClientId()+" , Received clientId: "+acmeIdToken.getClientId());
			return false;
		}
		
		/*
		 * Id Token shouldn't be expired.
		 */
		if(System.currentTimeMillis() < acmeIdToken.getExpirationTime()) {
			System.out.println("Id token is expired");
			return false;
		}
		
		return true;
	}
}
