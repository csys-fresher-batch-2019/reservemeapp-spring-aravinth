package com.chainsys.reservemeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@ServletComponentScan("com.chainsys.reservemeapp")
public class ReservemeappApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ReservemeappApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ReservemeappApplication.class, args);
	}

}
