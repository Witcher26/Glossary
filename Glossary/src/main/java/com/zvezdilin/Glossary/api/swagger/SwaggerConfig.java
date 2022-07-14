package com.zvezdilin.Glossary.api.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customAPI() {
        return new OpenAPI()
                .info(
                        new Info().title("My Glossary")
                                .version("1.0.0")
                                .contact(new Contact()
                                        .email("1816178@mail.ru")
                                        .url("https://github.com/Witcher26/Glossary")
                                        .name("Zvezdilin Igor")));
    }
}
