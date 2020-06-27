package com.revature.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan
public class Config {
	
	@Bean(value = "restTemplate")
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
	}
}