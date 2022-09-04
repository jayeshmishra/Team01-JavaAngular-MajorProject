package com.cybage.food;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class OnlineFoodOrderingAppApplication {

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodOrderingAppApplication.class, args);
	}
	
	 @Bean
	    MultipartConfigElement multipartConfigElement() {
	        MultipartConfigFactory factory = new MultipartConfigFactory();
	        factory.setMaxFileSize(DataSize.ofKilobytes(1024));
	        factory.setMaxRequestSize(DataSize.ofKilobytes(512));
	        return factory.createMultipartConfig();
	    }

	    @Bean
	    WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/files")
	                        .allowedOrigins("http://localhost:4200");
	            }
	        };
	    }
}
