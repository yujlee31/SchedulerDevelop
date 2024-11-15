package com.example.scheduler_develop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SchedulerDevelopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerDevelopApplication.class, args);
	}

}
