package com.gametrader.gametradersupportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GametraderSupportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GametraderSupportServiceApplication.class, args);
	}

}
