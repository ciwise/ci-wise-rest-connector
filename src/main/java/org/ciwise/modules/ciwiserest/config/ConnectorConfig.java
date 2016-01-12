package org.ciwise.modules.ciwiserest.config;

import org.mule.api.annotations.components.Configuration;

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {

	private final String reply = "Hello";
	private final String greeting = "How are you?";

	public String getReply() {
		return reply;
	}
	public String getGreeting() {
		return greeting;
	}
	
}