package com.finastra.ffdc.liq.model.customer;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "shortName", "legalName", "externalId", "id" })
public class CustomerIdentifier {

	@JsonProperty("shortName")
	private String shortName;
	@JsonProperty("legalName")
	private String legalName;
	@JsonProperty("externalId")
	private String externalId;
	@JsonProperty("id")
	private String id;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("shortName")
	public String getShortName() {
		return shortName;
	}

	@JsonProperty("shortName")
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@JsonProperty("legalName")
	public String getLegalName() {
		return legalName;
	}

	@JsonProperty("legalName")
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	@JsonProperty("externalId")
	public String getExternalId() {
		return externalId;
	}

	@JsonProperty("externalId")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
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