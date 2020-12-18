package com.finastra.ffdc.liq.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.finastra.ffdc.liq.customer.auth.Authentication;
import com.finastra.ffdc.liq.customer.auth.OAuth;

@Component("com.finastra.ffdc.liq.customer.ApiClient")
public class ApiClient {
    
    private String authCode;
    
    private Map<String, Authentication> authentications;
    

    public String getAuthCode() {
		return authCode;
	}


	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}


	public ApiClient() {
		init();
    }
	
	 /**
     * Get authentications (key: authentication name, value: authentication).
     * @return Map the currently configured authentication types
     */
    public Map<String, Authentication> getAuthentications() {
        return authentications;
    }

    /**
     * Get authentication for the given name.
     *
     * @param authName The authentication name
     * @return The authentication, null if not found
     */
    public Authentication getAuthentication(String authName) {
        return authentications.get(authName);
    }

    protected void init() {

        // Setup authentications (key: authentication name, value: authentication).
        authentications = new HashMap<String, Authentication>();
        authentications.put("Oauth2", new OAuth());
        // Prevent the authentications from being modified.
        authentications = Collections.unmodifiableMap(authentications);
    }

  
}
