package com.intelligent1069.spring.jpa.springbootjpa.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	  public static final Contact DEFAULT_CONTACT = new Contact("Virus", "1069", "virus@1069.com");
	  public static final Set<String> DEFAULT_PROD_CONS = new HashSet<String>(Arrays.asList("application/json","application/xml"));
	  
	  public static final ApiInfo DEFAULT_API_INFO = 
			  	new ApiInfo("Rest API Fun Doc", 
			  				"Rest API Fun Desc", 
			  				"1.0", 
			  				"urn:tos",
			  				DEFAULT_CONTACT, 
			  				"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", 
			  				new ArrayList<VendorExtension>());
	
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_12).apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PROD_CONS).consumes(DEFAULT_PROD_CONS);
	}
}
