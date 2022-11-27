package com.Project_N7.boat_management.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories("com.Project_N7.boat_management.repository")
@EntityScan("com.Project_N7.boat_management.entity")
@ComponentScan({"com.Project_N7.boat_management", "com.Project_N7.boat_management.repository"})
public class BoatManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(BoatManagementApplication.class, args);

	}

	/**
	 * Api.
	 *
	 * @return the docket
	 */
	@Configuration
	public class SpringFoxConfig {
		@Bean
		@ConfigurationProperties(prefix = "spring.datasource")
		public DataSource datasource() {
			return DataSourceBuilder.create().build();
		}

		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com"))
					.paths(PathSelectors.any())
					.build()
					.pathMapping("/");
		}

		@Bean
		@ConfigurationProperties(prefix = "spring.secondDatasource")
		public DataSource secondDB() {
			return DataSourceBuilder.create().build();


		}
	}

}


