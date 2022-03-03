package com.dio.desafio.BancoGFB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
public class BancoGfbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoGfbApplication.class, args);
	}

}
