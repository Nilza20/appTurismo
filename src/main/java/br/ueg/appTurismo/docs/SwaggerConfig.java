package br.ueg.appTurismo.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiDoc() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.ueg.appTurismo.controllers"))
				.build()
				.apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("Sistema para Turistas em Santa Helena - GO")
				.description("Projeto para a disciplina de Prog. III")
				.version("0.0.1")
				.contact(new Contact("Matheus", "ueg.br/si/matheus", "matheuso@ueg.br"))
				.license("Apache License version 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}
	
	/* PARA VISUALISAR ADICIONE (swagger-ui.html) À FRENTE DO LINK http://localhost:8080/*/
	/* http://localhost:8080/swagger-ui.html */
}
