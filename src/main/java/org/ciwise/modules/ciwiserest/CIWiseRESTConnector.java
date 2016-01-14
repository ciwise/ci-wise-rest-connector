package org.ciwise.modules.ciwiserest;

import org.ciwise.modules.ciwiserest.client.RestClient;
import org.ciwise.modules.ciwiserest.config.ConnectorConfig;
import org.ciwise.modules.ciwiserest.entity.Account;
import org.ciwise.modules.ciwiserest.exception.CIWiseRESTConnectorException;
import org.ciwise.modules.ciwiserest.exception.CIWiseRESTConnectorTokenExpiredException;
import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.lifecycle.Start;

@Connector(name="ci-wise-rest", friendlyName="CIWiseREST")
public class CIWiseRESTConnector {

    @Config
    ConnectorConfig config;

    private String token;
	private RestClient client;

    @Start
    public void init() {
        setClient(new RestClient(this));
    }    
    /**
     * Custom processor
     *
     * @param friend Name to be used to generate a greeting message.
     * @return A greeting message
     */
    @Processor
    public String greet(String friend) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
        return config.getGreeting() + " " + friend + ". " + config.getReply();
    }

    @Processor(friendlyName="Get X-Auth Token")
    public String getXAuthToken() throws CIWiseRESTConnectorException, CIWiseRESTConnectorTokenExpiredException {
        org.ciwise.modules.ciwiserest.entity.Token token = getClient().getXAuthToken();
    	return "The token is: " + (String) token.getToken();
    }
 
    @Processor(friendlyName="Get Accounts")
    public String getAccounts() throws CIWiseRESTConnectorException, CIWiseRESTConnectorTokenExpiredException {
    	Account[] array = getClient().getAccounts();
    	String retStr = "";
    	for(int i=0; i < array.length; i++)
    	{
    	    retStr = retStr + array[i].getId() + "," + array[i].getName() + "," + array[i].getAcctno() + "\n";
    	    
    	}
    	
    	return retStr;
    }
    
    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
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
	/**
	 * @return the client
	 */
	public RestClient getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(RestClient client) {
		this.client = client;
	}
}