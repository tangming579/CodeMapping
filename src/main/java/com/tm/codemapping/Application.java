package com.tm.codemapping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@MapperScan("com.tm.codemapping.mapper")
@EnableWebSecurity 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
