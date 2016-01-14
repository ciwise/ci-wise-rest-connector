package org.ciwise.modules.ciwiserest.entity;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * POJO for mapping with JSON response api/authenticate
 * 
 * @author David L. Whitehurst
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "expires", "token" })
public class Token {

	@JsonProperty("expires")
	private Object expires;
	@JsonProperty("token")
	private Object token;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The expires
	 */
	@JsonProperty("expires")
	public Object getExpires() {
		return expires;
	}

	/**
	 * 
	 * @param expires
	 *            The expires
	 */
	@JsonProperty("expires")
	public void setExpires(Object expires) {
		this.expires = expires;
	}

	/**
	 * 
	 * @return The token
	 */
	@JsonProperty("token")
	public Object getToken() {
		return token;
	}

	/**
	 * 
	 * @param token
	 *            The token
	 */
	@JsonProperty("token")
	public void setToken(Object token) {
		this.token = token;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}