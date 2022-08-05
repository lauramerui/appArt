package com.daw.appart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.daw.appart.model")
@EnableJpaRepositories(basePackages = "com.daw.appart.repository")
public class AppArtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppArtApplication.class, args);
	}

}
