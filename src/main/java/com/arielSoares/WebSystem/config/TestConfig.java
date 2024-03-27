package com.arielSoares.WebSystem.config;

import com.arielSoares.WebSystem.entities.User;
import com.arielSoares.WebSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "ariel", "ariel.sfranco@gmail.com", true, "ariel","123");
        User u2 = new User(null, "Jonata", "jonata@gmail.com", true, "ariel","123");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
