package com.finastra.ffdc.liq.schedular;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.finastra.ffdc.liq.api.ApiClient;
import com.finastra.ffdc.liq.customer.auth.OAuth;
import com.finastra.ffdc.liq.services.Authorization;



@Component
public class ScheduledTasks {
	
	@Autowired
	private ApiClient client;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

//	@Scheduled(fixedRate = 10000)
//	public void performTask() {
//
//		
//
//	}

	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void performDelayedTask() {
		if(null != ((OAuth) client.getAuthentication("Oauth2")).getAccessToken() 
				&& (!((OAuth) client.getAuthentication("Oauth2")).getAccessToken().isEmpty())) {
			new Authorization().getRefreshToken(client);
		}
		
	}

//	@Scheduled(cron = "*/5 * * * * *")
//	public void performTaskUsingCron() {
//
//	}
}
