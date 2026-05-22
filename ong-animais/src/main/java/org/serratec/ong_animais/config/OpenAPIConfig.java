package org.serratec.ong_animais.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI myOpenAPI(){
        Contact contato = new Contact();
        contato.setEmail("matheus.lahr@serratec.org.br");
        contato.setName("Matheus Lahr");

        License apacheLicense = new License().name("Apache License")
            .url("https://www.apache.org/licenses/License-2.0");

        Info info = new Info()
            .title("API de ONG de adoção de animais")
            .version("1.0")
            .contact(contato)
            .description("Api do trabalho individual")
            .termsOfService("https://serratec.org.br")
            .license(apacheLicense);

        return new OpenAPI().info(info);
    }
}
