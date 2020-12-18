package com.finastra.ffdc.liq.model.deal;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "dealName", "alias", "trackingNumber", "alternateId", "ansiId" })
public class DealIdentifier {

	@JsonProperty("id")
	private String id;
	@JsonProperty("dealName")
	private String dealName;
	@JsonProperty("alias")
	private String alias;
	@JsonProperty("trackingNumber")
	private String trackingNumber;
	@JsonProperty("alternateId")
	private String alternateId;
	@JsonProperty("ansiId")
	private String ansiId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("dealName")
	public String getDealName() {
		return dealName;
	}

	@JsonProperty("dealName")
	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	@JsonProperty("alias")
	public String getAlias() {
		return alias;
	}

	@JsonProperty("alias")
	public void setAlias(String alias) {
		this.alias = alias;
	}

	@JsonProperty("trackingNumber")
	public String getTrackingNumber() {
		return trackingNumber;
	}

	@JsonProperty("trackingNumber")
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	@JsonProperty("alternateId")
	public String getAlternateId() {
		return alternateId;
	}

	@JsonProperty("alternateId")
	public void setAlternateId(String alternateId) {
		this.alternateId = alternateId;
	}

	@JsonProperty("ansiId")
	public String getAnsiId() {
		return ansiId;
	}

	@JsonProperty("ansiId")
	public void setAnsiId(String ansiId) {
		this.ansiId = ansiId;
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