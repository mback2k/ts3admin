package de.uxnr.ts3.admin.util;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class ProxyAuth extends Authenticator {
	private PasswordAuthentication auth;

	public ProxyAuth(String username, String password) {
		auth = new PasswordAuthentication(username, password == null ? new char[] {} : password.toCharArray());
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return auth;
	}
}
