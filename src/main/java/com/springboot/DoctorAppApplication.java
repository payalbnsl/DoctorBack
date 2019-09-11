package com.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy.RepositoryDetectionStrategies;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
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
	
	@Bean
	public Docket getBean() {
		 return new Docket(DocumentationType.SWAGGER_2)  
		          .select()      
		          .apis(RequestHandlerSelectors.basePackage("com.springboot"))              
		          .paths(PathSelectors.any())
		          .build();  
	}
}
