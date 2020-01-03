package com.example.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication
				.run(DependencyInjectionApplication.class, args);

		UserService oUserService = context.getBean(UserService.class);
		String name = oUserService.getFullName();

		System.out.println("###############################");
		System.out.println(name);
		System.out.println("###############################");

	}

}

