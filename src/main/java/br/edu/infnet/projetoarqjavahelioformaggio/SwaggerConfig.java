package br.edu.infnet.projetoarqjavahelioformaggio;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API: tira teima eleitoral")
                .version("1.0")
                .description("API para ghestão dos candidatos e eleitores")
                .contact(new Contact()
                    .name("Helio Teixeira Formaggio Jr")
                    .email("helio.tjunior@al.infnet.edu.br")));
    }
}