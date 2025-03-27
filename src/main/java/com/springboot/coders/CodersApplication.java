package com.springboot.coders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class CodersApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CodersApplication.class, args);

		//
//		for (String bean : context.getBeanDefinitionNames()) {
//			System.out.println("Beans: " + bean);
//		}
//		System.out.println("Total beans are: " + context.getBeanDefinitionCount());
	}

}
