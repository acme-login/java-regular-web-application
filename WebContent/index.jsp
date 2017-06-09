<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HACKHATON</title>
<link rel="icon" 
      type="image/png" 
      href="assets/acme.png">
</head>
<body style="background: #0A1B37;text-align: center;color:#40A3DB;">
	<%
		/* REQUIRED. Client Identifier that is given by Acme for your Acme Client Configuration. Change it with your Client Id. */
		String clientId = "7d18f11f-2bda-4c36-b71f-7c99d3e502fd";

		/* REQUIRED. Redirection URI to which the response will be sent. 
		 This URI MUST exactly match one of the Callback URL value that is provided on your Acme Client Configuration.
		 The Redirection URI SHOULD use the https scheme; however, it MAY use the http scheme. Change it with your Callback URL. */
		String redirectUri = "http://localhost:8082/AcmeClientWeb/AppServlet";

		/*REQUIRED. OpenID Connect requests MUST contain the openid scope value. 
		OPTIONAL scope values of profile, email, address and phone are also defined. Set required scopes here according to details on Acme developer content*/
		String scopes = "openid email address phone profile";

		/*RECOMMENDED. Opaque value used to maintain state between the request and the callback.
		Typically, Cross-Site Request Forgery (CSRF, XSRF) mitigation is done by cryptographically binding the value of this parameter with a browser cookie.*/
		String state = UUID.randomUUID().toString();
		session.setAttribute("state", state);
	%>
	<h1 >Welcome to Hackathon</h1>
	<a href="https://portal.acmelogin.com/auth/realms/AgT1-hAT_oZ3NzC_/protocol/openid-connect/auth?response_type=code&client_id=<%=clientId%>&redirect_uri=<%=redirectUri%>&scope=<%=scopes%>&state=<%=state%>">
		<img src="assets/login_with_acme.png" alt="Sign in with Acme">
	</a>

</body>
</html>