package org.ciwise.modules.ciwiserest.config;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.param.Default;

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {


    private final String apiUrl = "http://localhost:8080";
	
	private final String greeting = "Hello";
	private final String reply = "How are you?";
	private final String username = "user";
	private final String password = "user";
	
	public String getReply() {
		return reply;
	}
	public String getGreeting() {
		return greeting;
	}
	/**
	 * @return the apiUrl
	 */
	public String getApiUrl() {
		return apiUrl;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
}