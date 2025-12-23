package com.javanauta.desafio4;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Gerenciamento produtos", version = "1", description = "API para controle de produtos"))
@SpringBootApplication
public class Desafio4Application {

	public static void main(String[] args) {
		SpringApplication.run(Desafio4Application.class, args);
	}

}
