package org.ciwise.modules.ciwiserest.client;

import org.ciwise.modules.ciwiserest.CIWiseRESTConnector;
import org.ciwise.modules.ciwiserest.exception.CIWiseRESTConnectorException;
import org.ciwise.modules.ciwiserest.exception.CIWiseRESTConnectorTokenExpiredException;
import org.ciwise.modules.ciwiserest.entity.Account;
import org.ciwise.modules.ciwiserest.entity.Token;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class RestClient {
	
	/**
	 * Jersey client instance
	 */
	private Client client; 
	
	/**
	 * API object resource
	 */
	private WebResource apiResource;
	
	/**
	 * This connector
	 */
	private CIWiseRESTConnector connector;
	
	/**
	 * API authentication token
	 */
	private String token;

	public RestClient(CIWiseRESTConnector connector) {

		/* wrap client with connector */
		setConnector(connector);

		/* use a default config for this simple connector */
		ClientConfig clientConfig = new DefaultClientConfig();

		/* Enable support for JSON to POJO entity mapping in Jersey */
		clientConfig.getFeatures().put(
				com.sun.jersey.api.json.JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		this.client = Client.create(clientConfig);
		this.apiResource = this.client.resource(getConnector().getConfig().getApiUrl());
		
	}
	
	/**
	 * Executes an API request
	 *
	 */
	private <T> T execute(WebResource webResource, String method,
			Class<T> returnClass)
			throws CIWiseRESTConnectorTokenExpiredException,
			CIWiseRESTConnectorException {

		/**
		 * Call HTTP Method
		 */
		if (connector.getToken() == null) {
			Token token = getXAuthToken();
			if (token != null) {
				connector.setToken((String) token.getToken()); 
			}
		}
		ClientResponse clientResponse = webResource.accept(
				MediaType.APPLICATION_JSON).header("X-Auth-Token", connector.getToken())
				.method(method, ClientResponse.class);
		if (clientResponse.getStatus() == 200) {
			return clientResponse.getEntity(returnClass);
		} else if (clientResponse.getStatus() == 401) {
			throw new CIWiseRESTConnectorTokenExpiredException(
					"The access token has expired; "
							+ clientResponse.getEntity(String.class));
		} else {
			throw new CIWiseRESTConnectorException(String.format(
					"ERROR - statusCode: %d - message: %s",
					clientResponse.getStatus(),
					clientResponse.getEntity(String.class)));
		}
	}
	
	/**
	 * Executes an authentication request via HTTP POST
	 *
	 */
	
	private <T> T executeAuthenticationPost(WebResource webResource,
			Class<T> returnClass)
			throws CIWiseRESTConnectorTokenExpiredException,
			CIWiseRESTConnectorException {

		// Map query params for POST operation MultivaluedMap, MultivaluedMapImpl
		
		MultivaluedMap<String,String> queryParams = new MultivaluedMapImpl();
		queryParams.add("username",
				getConnector().getConfig().getUsername());
		queryParams.add("password",
				getConnector().getConfig().getPassword());

		/**
		 * Call HTTP POST
		 */
		ClientResponse clientResponse = webResource.queryParams(queryParams)
				.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);

		if (clientResponse.getStatus() == 200) {
			return clientResponse.getEntity(returnClass);
		} else if (clientResponse.getStatus() == 401) {
			throw new CIWiseRESTConnectorTokenExpiredException(
					"The access token has expired; "
							+ clientResponse.getEntity(String.class));
		} else {
			throw new CIWiseRESTConnectorException(String.format(
					"ERROR - statusCode: %d - message: %s",
					clientResponse.getStatus(),
					clientResponse.getEntity(String.class)));
		}
	}

	public Token getXAuthToken() throws CIWiseRESTConnectorException,
		CIWiseRESTConnectorTokenExpiredException {
		WebResource webResource = getApiResource().path("api").path(
				"authenticate");
		return executeAuthenticationPost(webResource, Token.class);
	}
	
	public Account[] getAccounts() throws CIWiseRESTConnectorException,
	CIWiseRESTConnectorTokenExpiredException {

		WebResource webResource = getApiResource().path("api").path(
		"genaccounts");
		return execute(webResource, "GET", Account[].class);
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the apiResource
	 */
	public WebResource getApiResource() {
		return apiResource;
	}

	/**
	 * @param apiResource the apiResource to set
	 */
	public void setApiResource(WebResource apiResource) {
		this.apiResource = apiResource;
	}

	/**
	 * @return the connector
	 */
	public CIWiseRESTConnector getConnector() {
		return connector;
	}

	/**
	 * @param connector the connector to set
	 */
	public void setConnector(CIWiseRESTConnector connector) {
		this.connector = connector;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
}
