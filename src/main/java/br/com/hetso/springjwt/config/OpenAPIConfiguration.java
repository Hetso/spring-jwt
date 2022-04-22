package br.com.hetso.springjwt.config;


import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info = @Info(title = "Spring JWT APIs", version = "v1", description = "Documentation of Spring JWT APIs"))
public class OpenAPIConfiguration {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info()
						.title("FSpring JWT APIs")
						.version("v1")
						.license(new License()
								.name("Apache 2.0")
								.url("https://springdoc.org")));
	}
}
