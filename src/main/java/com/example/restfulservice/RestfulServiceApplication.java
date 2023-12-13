package com.example.restfulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestfulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulServiceApplication.class, args);

//		String[] allBeanNames = ac.getBeanDefinitionNames();
//		for(String beanName:allBeanNames){
//			System.out.println(beanName);
//		}
	}
}
