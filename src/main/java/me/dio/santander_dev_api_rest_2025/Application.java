package me.dio.santander_dev_api_rest_2025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * Rodar com dev usando o application-dev.yml
 * Para rodar o projeto, execute o comando abaixo no terminal:
 * # vscode Maven Linux:
 * ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
 *
 * # vscode Maven Windows:
 * mvnw spring-boot:run -Dspring-boot.run.profiles=dev
 * mvn spring-boot:run -Dspring-boot.run.profiles=dev
 *
 * # vscode Gradle Windows
 * .\gradlew bootRun --args="--spring.profiles.active=dev"
 */
@SpringBootApplication
public class Application {

	// Acesso http://localhost:8080
	// Acesso http://localhost:8080/swagger-ui/index.html
	// Acesso http://localhost:8080/v3/api-docs
	// Acesso http://localhost:8080/h2-console 
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
