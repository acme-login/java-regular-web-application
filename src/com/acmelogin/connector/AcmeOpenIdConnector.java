package com.acmelogin.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author Acme Developers
 *
 */
public class AcmeOpenIdConnector {

	public AcmeUserTokens getAcmeTokensForUser(final AcmeOpenIdConnectConfiguration acmeConfiguration, final String authorizationCode)  throws URISyntaxException, ClientProtocolException, IOException {
		AcmeUserTokens acmeUserTokens = new AcmeUserTokens();
		
		URI uri = new URIBuilder().setScheme("https")
				.setHost(acmeConfiguration.getAcmeServerUrl())
		        .setPath(acmeConfiguration.getAcmeTokenEndPointPath())
		        .build();
		HttpPost postRequest = new HttpPost(uri);  
		postRequest.setHeader("Content-type", "application/x-www-form-urlencoded");
		postRequest.setHeader("Accept", "application/json");
		
		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("grant_type", "authorization_code"));
		params.add(new BasicNameValuePair("code", authorizationCode));
		params.add(new BasicNameValuePair("redirect_uri", acmeConfiguration.getRedirectUrl()));
		params.add(new BasicNameValuePair("client_id", acmeConfiguration.getClientId()));
		params.add(new BasicNameValuePair("client_secret", acmeConfiguration.getClientSecret()));
		postRequest.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(postRequest);
		
		int responseCode = response.getStatusLine().getStatusCode();
		if(responseCode == 200) {
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));
			
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			
			acmeUserTokens = gson.fromJson(result.toString(), AcmeUserTokens.class);
			
			String idTokenData = AcmeUtil.decodeIdTokenDataSection(acmeUserTokens.getIdToken());
			AcmeUserIdToken acmeIdToken = gson.fromJson(idTokenData, AcmeUserIdToken.class);
			acmeUserTokens.setAcmeUserIdToken(acmeIdToken);
			
			//System.out.println("Access Token Data::");
			//System.out.println(acmeUserTokens.getAccessToken());
			
			//System.out.println("Id Token Data::");
			//System.out.println(idTokenData);
		}
		
		return acmeUserTokens;
	}
	
	
	public String getUserInfo(final AcmeOpenIdConnectConfiguration acmeConfiguration, final String accessToken) throws URISyntaxException, ClientProtocolException, IOException {
		URI uri = new URIBuilder().setScheme("https")
				.setHost(acmeConfiguration.getAcmeServerUrl())
		        .setPath(acmeConfiguration.getAcmeUserinfoEndPointPath())
		        .build();
		HttpGet getRequest = new HttpGet(uri);
		getRequest.setHeader("Authorization", "Bearer "+accessToken);
		getRequest.setHeader("Accept", "application/jwt");
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(getRequest);
		
		int responseCode = response.getStatusLine().getStatusCode();
		StringBuffer result = new StringBuffer();
		if(responseCode == 200) {
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));
			
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		}
		
		return result.toString();
	}
	
	public String getLogoutRequestUrl(final AcmeOpenIdConnectConfiguration acmeConfiguration, final String accessToken) {
		StringBuffer logoutRedirectUrl = new StringBuffer();
		logoutRedirectUrl.append("https://");
		logoutRedirectUrl.append(acmeConfiguration.getAcmeServerUrl());
		logoutRedirectUrl.append(acmeConfiguration.getAcmeEndSessionEndPointPath()+"?");
		logoutRedirectUrl.append("id_token_hint="+accessToken);
		logoutRedirectUrl.append("&post_logout_redirect_uri=");
		logoutRedirectUrl.append(acmeConfiguration.getLogoutRedirectUrl());
		return logoutRedirectUrl.toString();
	}
}
