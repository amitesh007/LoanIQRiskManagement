package com.finastra.ffdc.liq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class LoanIQRiskConfig {
	
	@Value("${credit.risk.clientid}")
    private String clientId;
	
	@Value("${credit.risk.clientsecret}")
	private String clientSecret;
	
	@Value("${credit.risk.token.url}")
	private String tokenUrl;
	
	@Value("${credit.risk.auth.url}")
	private String authUrl;
	
	@Value("${credit.risk.callback.url}")
	private String callbackUrl;
	
	@Value("${credit.risk.customer.search.url}")
	private String customerSearchUrl;
	
	@Value("${credit.risk.deal.search.url}")
	private String dealSearchUrl;
	
	@Value("${credit.risk.past.dues.deal.url}")
	private String pastDuesDealUrl;
	
	@Value("${credit.risk.past.dues.customer.url}")
	private String pastDuesCustomerUrl;
	
	@Value("${credit.risk.home.page}")
	private String homePageUrl;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getCustomerSearchUrl() {
		return customerSearchUrl;
	}

	public void setCustomerSearchUrl(String customerSearchUrl) {
		this.customerSearchUrl = customerSearchUrl;
	}

	public String getDealSearchUrl() {
		return dealSearchUrl;
	}

	public void setDealSearchUrl(String dealSearchUrl) {
		this.dealSearchUrl = dealSearchUrl;
	}

	public String getPastDuesDealUrl() {
		return pastDuesDealUrl;
	}

	public void setPastDuesDealUrl(String pastDuesDealUrl) {
		this.pastDuesDealUrl = pastDuesDealUrl;
	}

	public String getPastDuesCustomerUrl() {
		return pastDuesCustomerUrl;
	}

	public void setPastDuesCustomerUrl(String pastDuesCustomerUrl) {
		this.pastDuesCustomerUrl = pastDuesCustomerUrl;
	}

	public String getHomePageUrl() {
		return homePageUrl;
	}

	public void setHomePageUrl(String homePageUrl) {
		this.homePageUrl = homePageUrl;
	}
    
    
}
