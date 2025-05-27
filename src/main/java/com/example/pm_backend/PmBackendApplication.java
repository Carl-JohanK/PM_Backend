package com.example.pm_backend;

import com.example.pm_backend.model.IngredientModel;
import com.example.pm_backend.model.RecipeModel;
import com.example.pm_backend.repository.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PmBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmBackendApplication.class, args);
	}

}
