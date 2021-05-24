package employees.b2w.digital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerOpenApiConfig {                                    
	  
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("B2W Companhia Digital API")
	              .description("B2W Digital é uma empresa de comércio eletrônico criada no final de 2006 pela fusão entre Submarino, Shoptime, Americanas.com. A B2W Digital é uma empresa de capital aberto na bolsa de valores brasileira, a B3, ticker BTOW3")
	              .version("v0.0.1")
	              .license(new License().name("B2W Companhia Digital").url("https://ri.b2w.digital/")))
	              .externalDocs(new ExternalDocumentation()
	              .description("Esse documento tem como orientação da utilização da APIs com base no diagrama informado de employees (Os testes deverão ser realizados no POSTMAN para sermos assertiva) no OPENAPI alguns parâmetros e campos são obrigatórios por isso não houve configurações para testes no OpenApi. ")
	              .url("https://www.postman.com/"));
	  }

    //http://localhost:8080/swagger-ui.html         
}