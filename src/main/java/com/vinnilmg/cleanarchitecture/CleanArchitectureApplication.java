package com.vinnilmg.cleanarchitecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CleanArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanArchitectureApplication.class, args);
	}

}
