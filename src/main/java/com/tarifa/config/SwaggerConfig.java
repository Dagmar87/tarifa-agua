package com.tarifa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	@Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()

                .info(new Info()

                        .title("API Tabela Tarifária")

                        .description(
                                "API para cálculo de tarifa de água")

                        .version("1.0")

                        .contact(new Contact()

                                .name("José Dagmar")

                                .email("seu-email@email.com")))

                .externalDocs(
                        new ExternalDocumentation()

                                .description("Documentação")
                                .url("https://github.com"));
    }

}
