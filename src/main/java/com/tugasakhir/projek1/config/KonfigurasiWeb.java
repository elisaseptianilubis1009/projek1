package com.tugasakhir.projek1.config;

import java.time.Duration;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class KonfigurasiWeb extends WebMvcConfigurerAdapter {
			
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login_user");
		
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	 
	    return builder
	            .setConnectTimeout(Duration.ofMillis(3000))
	            .setReadTimeout(Duration.ofMillis(3000))
	            .build();
	}
}



