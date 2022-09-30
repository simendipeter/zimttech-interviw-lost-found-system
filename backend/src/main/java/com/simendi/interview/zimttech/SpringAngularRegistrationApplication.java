package com.simendi.interview.zimttech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@ComponentScan(basePackages = {
        "com.simendi.interview.zimttech.dao",
        "com.simendi.interview.zimttech.endpoint",
        "com.simendi.interview.zimttech.service",
        "com.simendi.interview.zimttech.mapper",
        "com.simendi.interview.zimttech.validation",
}, lazyInit = true)
@EntityScan(basePackages = {"com.simendi.interview.zimttech.model"})
@EnableJpaRepositories(basePackages = {"com.simendi.interview.zimttech.dao"})*/
@SpringBootApplication
public class SpringAngularRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularRegistrationApplication.class, args);
	}

}
