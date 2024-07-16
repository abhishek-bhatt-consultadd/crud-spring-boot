package com.example.crud.crud_app;

import com.example.crud.crud_app.model.User;
import com.example.crud.crud_app.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.crud.crud_app.model.ERole;
import com.example.crud.crud_app.model.Role;
import com.example.crud.crud_app.repo.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.Encoder;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CrudAppApplication implements CommandLineRunner{

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(
            CrudAppApplication.class,
            args);
	}

	@Override
	public void run(String... arg0) throws Exception {
			Role userRole = new Role(ERole.ROLE_USER);
			Role adminRole = new Role(ERole.ROLE_ADMIN);
			Role modRole = new Role(ERole.ROLE_MODERATOR);
			roleRepository.save(userRole);
			roleRepository.save(adminRole);
			roleRepository.save(modRole);

			User admin = new User("admin", "admin@gmail.com", encoder.encode("12345678"));
			Set<Role> roles = new HashSet<>();
			Role admRole = roleRepository.findByName(ERole.ROLE_ADMIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(adminRole);
			admin.setRoles(roles);
			userRepository.save(admin);
	}
}
