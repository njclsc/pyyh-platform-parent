package com.pyyh.manager.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.pyyh.manager"})
@MapperScan(basePackages = {"com.pyyh.manager"})
@EnableDiscoveryClient
@SpringBootApplication
public class ManagerStarter extends SpringBootServletInitializer{

	public static void main(String[] args){
		SpringApplication.run(ManagerStarter.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(ManagerStarter.class);
	}
	
}
