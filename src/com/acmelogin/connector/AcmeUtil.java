package com.acmelogin.connector;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author Acme Developers
 *
 */
public class AcmeUtil {

	public static void initializeConfiguration(AcmeOpenIdConnectConfiguration acmeOpenIdConnectConfiguration) {
		Properties configProperties;
		try {
			configProperties = getConfigProperties();
			acmeOpenIdConnectConfiguration.setRedirectUrl(configProperties.getProperty("your_redirect_url"));
			acmeOpenIdConnectConfiguration.setClientId(configProperties.getProperty("your_client_id"));
			acmeOpenIdConnectConfiguration.setClientSecret(configProperties.getProperty("your_client_secret"));
			acmeOpenIdConnectConfiguration.setLogoutRedirectUrl(configProperties.getProperty("your_logout_redirect_url"));
			acmeOpenIdConnectConfiguration.setAcmeServerUrl(configProperties.getProperty("acme_url"));
			acmeOpenIdConnectConfiguration.setAcmeTokenEndPointPath(configProperties.getProperty("acme_token_endpoint"));
			acmeOpenIdConnectConfiguration.setAcmeUserinfoEndPointPath(configProperties.getProperty("acme_userinfo_endpoint"));
			acmeOpenIdConnectConfiguration.setAcmeEndSessionEndPointPath(configProperties.getProperty("acme_endsession_endpoint"));
			acmeOpenIdConnectConfiguration.setExpectedIssuer(configProperties.getProperty("acme_issuer"));
		} catch (IOException e) {
			System.out.println("Cannot read configuration. Check if you located correctly");
			//TODO handle configuration error
		}
		
		System.out.println("Configuration is loaded");
	}
	
	public static Properties getConfigProperties() throws IOException {
		Properties prop = new Properties();
		InputStream inputStream = null;
		try {
			String propFileName = "/conf.properties";
 
			inputStream = AcmeUtil.class.getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return prop;
	}
	
	public static String base64UrlDecode(String input) {
        byte[] decodedBytes = base64UrlDecodeToBytes(input);
        String result = new String(decodedBytes, StandardCharsets.UTF_8);
        return result;
    }

    public static byte[] base64UrlDecodeToBytes(String input) {
        Base64 decoder = new Base64();//(-1, null, true);
        byte[] decodedBytes = decoder.decode(input.getBytes());
        return decodedBytes;
    }

    public static String decodeIdTokenDataSection(final String idToken) {
		String[] idTokenParts = idToken.split("\\.");
		String idTokenDataAsJsonStr = AcmeUtil.base64UrlDecode(idTokenParts[1]);
		return idTokenDataAsJsonStr;
	}
	
}
