package com.Project_N7.boat_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("boatdb_user")
public class boat_management_application {

	public static void main(String[] args) {

		SpringApplication.run(boat_management_application.class, args);

	}

	/**
	 * Api.
	 *
	 * @return the docket
	 */
	@Configuration
	public class SpringFoxConfig {
		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("boat_management"))
					.paths(PathSelectors.any())
					.build()
					.pathMapping("/");
		}

	}

}


