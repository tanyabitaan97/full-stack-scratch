package com.demo.springbootpaginationandsorting;

import com.demo.springbootpaginationandsorting.model.Plant;
import com.demo.springbootpaginationandsorting.repository.PlantRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ApplicationRunner run(PlantRepository plantRepository) throws Exception {
		return (ApplicationArguments args) -> {
			System.out.println("inside run");
			List<Plant> plants = Arrays.asList(
					new Plant("subalpine fir", "abies lasiocarpa", "pinaceae"),
					new Plant("sour cherry", "prunus cerasus", "rosaceae"),
					new Plant("asian pear", "pyrus pyrifolia", "rosaceae")
			);
			plantRepository.saveAll(plants);
			
		};

	}
}
