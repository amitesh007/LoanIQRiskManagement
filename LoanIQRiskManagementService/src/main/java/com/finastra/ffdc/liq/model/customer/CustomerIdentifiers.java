package com.finastra.ffdc.liq.model.customer;

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
@JsonPropertyOrder({ "customerIdentifiers" })
public class CustomerIdentifiers {

	@JsonProperty("customerIdentifiers")
	private List<CustomerIdentifier> customerIdentifiers = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("customerIdentifiers")
	public List<CustomerIdentifier> getCustomerIdentifiers() {
		return customerIdentifiers;
	}

	@JsonProperty("customerIdentifiers")
	public void setCustomerIdentifiers(List<CustomerIdentifier> customerIdentifiers) {
		this.customerIdentifiers = customerIdentifiers;
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