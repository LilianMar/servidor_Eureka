package com.co.maradiago.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroServicioUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioUsuariosApplication.class, args);
	}

}

