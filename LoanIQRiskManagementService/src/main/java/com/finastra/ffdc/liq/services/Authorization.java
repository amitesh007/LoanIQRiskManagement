package com.finastra.ffdc.liq.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finastra.ffdc.liq.LoanIQRiskConfig;
import com.finastra.ffdc.liq.api.ApiClient;
import com.finastra.ffdc.liq.customer.auth.OAuth;
import com.finastra.ffdc.liq.model.AccessToken;
import com.finastra.ffdc.liq.model.customer.CustomerIdentifier;
import com.finastra.ffdc.liq.model.customer.CustomerIdentifiers;
import com.finastra.ffdc.liq.model.deal.DealIdentifier;
import com.finastra.ffdc.liq.model.deal.DealIdentifiers;

@RestController
public class Authorization {
	
	@Autowired
	private ApiClient client;
	
	@Autowired
	private LoanIQRiskConfig config;

	
	@GetMapping("/authorization_code")
	public String getAuthCode(HttpServletRequest request,HttpServletResponse response) {
		String authorizationCode = "Empty";
		String token = "NONE";
		if(request != null) {
			authorizationCode = request.getParameter("code");
			client.setAuthCode(authorizationCode);
			if(null != authorizationCode && !authorizationCode.isEmpty()) {
				token = getAccessToken(authorizationCode);
			}
			
			if(null != token) {
				((OAuth) client.getAuthentication("Oauth2")).setAccessToken(token);
				try {
					response.sendRedirect(config.getHomePageUrl());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				try {
					response.sendRedirect(getAuthGrantType(config.getCallbackUrl()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return token;
	}
	
	@GetMapping("/search/customers/legalName/{legalName}")
	@ResponseBody
	public CustomerIdentifiers  getCustomersFromLegalName(@PathVariable String legalName,HttpServletResponse response) {
		List<CustomerIdentifier> list = new ArrayList<>();
		CustomerIdentifiers json =null;
		String url= config.getCustomerSearchUrl()+legalName;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + ((OAuth) client.getAuthentication("Oauth2")).getAccessToken());
		
		HttpEntity<String> request = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = buildRestTemplate();//new RestTemplate();
		try {
			ResponseEntity<CustomerIdentifiers> response1 = restTemplate.exchange(url, HttpMethod.GET,request, CustomerIdentifiers.class);

			if (null != response1 && response1.getStatusCode() != null) {
				System.out.println("Acess Token generation successful with reason - " + response1.getBody());
				json = response1.getBody();
				list = json.getCustomerIdentifiers();
			}
			System.out.println("list: \n" + list);
			
		} catch (Exception e) {
//			e.printStackTrace();
//			try {
//				response.sendRedirect(getAuthGrantType(LoanIQRiskServiceConstants.CALLBACKURL));
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
		
		return json;
	}
	
	
	@GetMapping("/search/deals/dealName/{dealName}")
	@ResponseBody
	public DealIdentifiers  getDealsFromLegalName(@PathVariable String dealName,HttpServletResponse response) {
		List<DealIdentifier> list = new ArrayList<>();
		DealIdentifiers json =null;
		String url= config.getDealSearchUrl()+dealName;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + ((OAuth) client.getAuthentication("Oauth2")).getAccessToken());
		
		HttpEntity<String> request = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = buildRestTemplate();//new RestTemplate();
		try {
			ResponseEntity<DealIdentifiers> response1 = restTemplate.exchange(url, HttpMethod.GET,request, DealIdentifiers.class);

			if (null != response1 && response1.getStatusCode() != null) {
				System.out.println("Acess Token generation successful with reason - " + response1.getBody());
				json = response1.getBody();
				list = json.getDealIdentifiers();
			}
			//System.out.println("list: \n" + list);
			
		} catch (Exception e) {
//			e.printStackTrace();
//			try {
//				response.sendRedirect(getAuthGrantType(LoanIQRiskServiceConstants.CALLBACKURL));
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
		
		return json;
	}
	
	
	@GetMapping("/past-dues/deal/{id}")
	@ResponseBody
	public String getPastDuesByDeal(@PathVariable String id,HttpServletResponse response) {
		//List<DealIdentifier> list = new ArrayList<>();
		String json =null;
		String url= config.getPastDuesDealUrl()+id;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + ((OAuth) client.getAuthentication("Oauth2")).getAccessToken());
		
		HttpEntity<String> request = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = buildRestTemplate();//new RestTemplate();
		try {
			ResponseEntity<String> response1 = restTemplate.exchange(url, HttpMethod.GET,request, String.class);

			if (null != response1 && response1.getStatusCode() != null) {
				System.out.println("Acess Token generation successful with reason - " + response1.getBody());
				json = response1.getBody();
				//list = json.getDealIdentifiers();
			}
			//System.out.println("list: \n" + list);
			
		} catch (Exception e) {
			e.printStackTrace();
//			try {
//				//response.sendRedirect(getAuthGrantType(LoanIQRiskServiceConstants.CALLBACKURL));
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
		
		return json;
	}
	
	@GetMapping("/past-dues/customer/{id}")
	@ResponseBody
	public String getPastDuesByCustomer(@PathVariable String id,HttpServletResponse response) {
		//List<DealIdentifier> list = new ArrayList<>();
		String json =null;
		String url= config.getPastDuesCustomerUrl()+id;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + ((OAuth) client.getAuthentication("Oauth2")).getAccessToken());
		
		HttpEntity<String> request = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = buildRestTemplate();//new RestTemplate();
		try {
			ResponseEntity<String> response1 = restTemplate.exchange(url, HttpMethod.GET,request, String.class);

			if (null != response1 && response1.getStatusCode() != null) {
				System.out.println("Acess Token generation successful with reason - " + response1.getBody());
				json = response1.getBody();
				//list = json.getDealIdentifiers();
			}
			//System.out.println("list: \n" + list);
			
		} catch (Exception e) {
			e.printStackTrace();
//			try {
//				response.sendRedirect(getAuthGrantType(LoanIQRiskServiceConstants.CALLBACKURL));
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
		
		return json;
	}
	
	@ResponseBody
	@GetMapping("/customerId/{id}")
	public String  getCustomerFromId(@PathVariable String id) {
		
		String json =null;
		String url= "https://api.fusionfabric.cloud/corporate/lending/customer/v1/customers/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + ((OAuth) client.getAuthentication("Oauth2")).getAccessToken());
		
		HttpEntity<String> request = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = buildRestTemplate();//new RestTemplate();
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,request, String.class);

			if (null != response && response.getStatusCode() != null) {
				System.out.println("Acess Token generation successful with reason - " + response.getBody());
				json = response.getBody();
			}
			//System.out.println("list: \n" + list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
	public String getAccessToken(String authorizationCode){
		String token = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "authorization_code");
		map.add("client_id", config.getClientId());
		map.add("client_secret", config.getClientSecret());
		map.add("code", authorizationCode);
		map.add("redirect_uri", config.getCallbackUrl());

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<AccessToken> response = restTemplate.exchange(config.getTokenUrl(), HttpMethod.POST,request, AccessToken.class);

			if (null != response && response.getStatusCode() != null) {
				System.out.println("Acess Token generation successful with reason - " + response.getBody());
				AccessToken json = response.getBody();
				token = json.getAccessToken();
			}
			System.out.println("TOKEN: \n" + token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return token;
	}
	
	
	
	
	
	@GetMapping("/refresh")
	public String getRefreshToken(HttpServletRequest request) {
		String authorizationCode = "Empty";
		String token = "NONE";
		if(request != null) {
			authorizationCode = request.getParameter("code");
			if(null != authorizationCode && !authorizationCode.isEmpty()) {
				//token = getRefreshToken(authorizationCode);
			}
			
			if(null != token) {
				((OAuth) client.getAuthentication("Oauth2")).setAccessToken(token);
			}
		}
		return token;
	}
	
	public void getRefreshToken(ApiClient client1){
		String url= "https://api.fusionfabric.cloud/corporate/lending/customer/v1/customers?legalName=NONE";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + ((OAuth) client1.getAuthentication("Oauth2")).getAccessToken());
		
		HttpEntity<String> request = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = buildRestTemplate();//new RestTemplate();
		try {
			ResponseEntity<CustomerIdentifiers> response = restTemplate.exchange(url, HttpMethod.GET,request, CustomerIdentifiers.class);

			if (null != response && response.getStatusCode() != null) {
				System.out.println("Acess Token generation successful with reason - " + response.getBody());
			}
			
		} catch (Exception e) {
			e.getLocalizedMessage();
			e.printStackTrace();
		}
	}
	
	protected RestTemplate buildRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // This allows us to read the response more than once - Necessary for debugging.
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(restTemplate.getRequestFactory()));
        return restTemplate;
    }
	
	private  String getAuthGrantType(String callbackURL){
	    return config.getAuthUrl() + "?response_type=code&client_id=" + config.getClientId() + "&redirect_uri=" + callbackURL + "&scope=openid";
	}
}
