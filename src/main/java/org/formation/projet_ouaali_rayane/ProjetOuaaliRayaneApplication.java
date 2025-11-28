package org.formation.projet_ouaali_rayane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.formation"})
@EnableJpaRepositories(basePackages = {"org.formation.repository"})
@EntityScan(basePackages = {"org.formation.entity"})
public class ProjetOuaaliRayaneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetOuaaliRayaneApplication.class, args);
    }
}
