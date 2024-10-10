package com.med.uread;

import com.med.uread.Entities.Role;
import com.med.uread.Repositories.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing // Elle permet à Spring Data JPA de surveiller les entités et de gérer automatiquement certains champs d'audit
@EnableAsync
public class UreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(UreadApplication.class, args);
    }

    @Bean
	public CommandLineRunner runner(RoleRepo roleRepository) {
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(Role.builder().name("USER").build());
			}
		};
	}

}
