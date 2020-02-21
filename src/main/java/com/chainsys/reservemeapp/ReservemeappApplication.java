package com.chainsys.reservemeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@ServletComponentScan("com.servlet")
public class ReservemeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservemeappApplication.class, args);
	}

}
