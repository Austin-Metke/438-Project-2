package com.example.fitness;

import org.springframework.boot.SpringApplication;

public class TestFitnessApplication {

	public static void main(String[] args) {
		SpringApplication.from(FitnessApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
