package com.foodorder;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.foodorder.repositories")
@EntityScan(basePackages = "com.foodorder.models")
public class FoodOrderingApplication {
	private static final Logger logger = LoggerFactory.getLogger(FoodOrderingApplication.class);

	public static void main(String[] args) {
		try {
			// Check for MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			logger.info("MySQL driver is present on the classpath.");
		} catch (ClassNotFoundException e) {
			logger.error("MySQL driver is NOT present on the classpath!", e);
			// Optional: exit the application gracefully if driver is not found
			System.exit(1);
		}

		// Run the Spring Boot application
		SpringApplication.run(FoodOrderingApplication.class, args);
	}
}
