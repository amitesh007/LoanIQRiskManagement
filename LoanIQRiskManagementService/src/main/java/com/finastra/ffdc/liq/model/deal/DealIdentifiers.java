package com.finastra.ffdc.liq.model.deal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dealIdentifiers" })
public class DealIdentifiers {

	@JsonProperty("dealIdentifiers")
	private List<DealIdentifier> dealIdentifiers = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("dealIdentifiers")
	public List<DealIdentifier> getDealIdentifiers() {
		return dealIdentifiers;
	}

	@JsonProperty("dealIdentifiers")
	public void setDealIdentifiers(List<DealIdentifier> dealIdentifiers) {
		this.dealIdentifiers = dealIdentifiers;
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
