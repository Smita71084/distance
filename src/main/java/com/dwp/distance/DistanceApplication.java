package com.dwp.distance;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DistanceApplication {

	 public static void main(String[] args) {
	 	 SpringApplication.run(DistanceApplication.class, args);
	 }

	 @Bean
	 public RestTemplate restTemplate(RestTemplateBuilder builder) {
		  return builder.build();
	 }


}
