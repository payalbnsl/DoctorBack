package com.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy.RepositoryDetectionStrategies;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.springboot.repository")
public class DoctorAppApplication implements RepositoryRestConfigurer{

	@Autowired MappingJackson2XmlHttpMessageConverter converter;
	
	public static void main(String[] args) {
		SpringApplication.run(DoctorAppApplication.class, args);
	}

	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.setRepositoryDetectionStrategy(RepositoryDetectionStrategies.ANNOTATED);
	}
	@Override
	 public void configureHttpMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
		 messageConverters.add(converter);
		 messageConverters.add(new ResourceHttpMessageConverter());
		
	 }
}
