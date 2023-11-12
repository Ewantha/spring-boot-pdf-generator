package com.eudagama12.example.pdfgenerator.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("PDF Generator")
                        .description("Application to create a PDF using an API")
                        .contact(new Contact().name("Ewantha Udagama").email("ewanthau@gmail.com").url("https://github.com/Ewantha"))
                        .version("v0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("itext Website")
                        .url("https://itextpdf.com/"));
    }
}
