package com.bfm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
//@EnableJpaRepositories(basePackages={"pl.springBootStarter.app"})
public class RestServiceMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceMainApplication.class, args);
		System.out.println("hello Aaishna");
	}

}
