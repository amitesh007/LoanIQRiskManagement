package com.finastra.ffdc.liq.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "access_token", "expires_in", "refresh_token", "refresh_expires_in", "scope", "token_type",
		"id_token" })
public class AccessToken {

	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("expires_in")
	private Integer expiresIn;
	@JsonProperty("refresh_token")
	private String refreshToken;
	@JsonProperty("refresh_expires_in")
	private Integer refreshExpiresIn;
	@JsonProperty("scope")
	private String scope;
	@JsonProperty("token_type")
	private String tokenType;
	@JsonProperty("id_token")
	private String idToken;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}

	@JsonProperty("access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@JsonProperty("expires_in")
	public Integer getExpiresIn() {
		return expiresIn;
	}

	@JsonProperty("expires_in")
	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	@JsonProperty("refresh_token")
	public String getRefreshToken() {
		return refreshToken;
	}

	@JsonProperty("refresh_token")
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@JsonProperty("refresh_expires_in")
	public Integer getRefreshExpiresIn() {
		return refreshExpiresIn;
	}

	@JsonProperty("refresh_expires_in")
	public void setRefreshExpiresIn(Integer refreshExpiresIn) {
		this.refreshExpiresIn = refreshExpiresIn;
	}

	@JsonProperty("scope")
	public String getScope() {
		return scope;
	}

	@JsonProperty("scope")
	public void setScope(String scope) {
		this.scope = scope;
	}

	@JsonProperty("token_type")
	public String getTokenType() {
		return tokenType;
	}

	@JsonProperty("token_type")
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	@JsonProperty("id_token")
	public String getIdToken() {
		return idToken;
	}

	@JsonProperty("id_token")
	public void setIdToken(String idToken) {
		this.idToken = idToken;
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