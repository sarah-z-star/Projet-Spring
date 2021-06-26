package com.miniProjet.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class MiniProjetEcommerceAppApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MiniProjetEcommerceAppApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MiniProjetEcommerceAppApplication.class);
	}

}
