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

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"acctno",
"id",
"name"
})
public class Account {

@JsonProperty("acctno")
private int acctno;
@JsonProperty("id")
private int id;
@JsonProperty("name")
private String name;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The acctno
*/
@JsonProperty("acctno")
public int getAcctno() {
return acctno;
}

/**
* 
* @param acctno
* The acctno
*/
@JsonProperty("acctno")
public void setAcctno(int acctno) {
this.acctno = acctno;
}

/**
* 
* @return
* The id
*/
@JsonProperty("id")
public int getId() {
return id;
}

/**
* 
* @param id
* The id
*/
@JsonProperty("id")
public void setId(int id) {
this.id = id;
}

/**
* 
* @return
* The name
*/
@JsonProperty("name")
public String getName() {
return name;
}

/**
* 
* @param name
* The name
*/
@JsonProperty("name")
public void setName(String name) {
this.name = name;
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