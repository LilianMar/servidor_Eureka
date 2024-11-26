package com.co.maradiago.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.co.maradiago.usuarios", "com.maradiago.common.usuario.models.entity"})
@EnableJpaRepositories("com.co.maradiago.usuarios.repository")
@EntityScan("com.maradiago.common.usuario.models.entity")
public class MicroServicioUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioUsuariosApplication.class, args);
	}

}

