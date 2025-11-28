package org.formation.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Banque - Projet Ouaali Rayane")
                        .description("API REST pour la gestion d'une banque avec clients, comptes et conseillers")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Rayane Ouaali")
                                .email("rayane@example.com")));
    }
}
