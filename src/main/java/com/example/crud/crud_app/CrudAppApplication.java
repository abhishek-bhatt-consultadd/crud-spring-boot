package com.example.crud.crud_app;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.crud.crud_app.model.ERole;
import com.example.crud.crud_app.model.Role;
import com.example.crud.crud_app.repo.RoleRepository;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(
            CrudAppApplication.class,
            args);
	}
}
