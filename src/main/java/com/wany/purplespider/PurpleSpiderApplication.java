package com.wany.purplespider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.wany.purplespider"})
public class PurpleSpiderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurpleSpiderApplication.class, args);
	}

}

