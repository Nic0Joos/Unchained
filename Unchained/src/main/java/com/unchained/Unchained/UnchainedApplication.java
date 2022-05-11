package com.unchained.Unchained;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UnchainedApplication {


	public static void main(String[] args) {
		SpringApplication.run(UnchainedApplication.class, args);
	}


}
