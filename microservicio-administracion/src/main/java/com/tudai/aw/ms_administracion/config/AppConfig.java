package com.tudai.aw.ms_administracion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean
	public RestTemplate obtenerRestTemplate() {
		return new RestTemplate();
	}
}
