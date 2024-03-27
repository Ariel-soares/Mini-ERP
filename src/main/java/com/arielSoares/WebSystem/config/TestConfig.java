package com.arielSoares.WebSystem.config;

import com.arielSoares.WebSystem.entities.Client;
import com.arielSoares.WebSystem.entities.Product;
import com.arielSoares.WebSystem.entities.User;
import com.arielSoares.WebSystem.repositories.ClientRepository;
import com.arielSoares.WebSystem.repositories.ProductRepository;
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
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "ariel", "ariel.sfranco@gmail.com", true, "ariel","123");
        User u2 = new User(null, "Jonata", "jonata@gmail.com", true, "ariel","123");

        Product p1 = new Product(null, "Monitor", "Monitor de computador", 300.00);
        Product p2 = new Product(null, "Computer", "Computer", 3000.00);

        Client c1 = new Client(null, "ariel", "Salvador", "Cliente", "75 9 91796995", "ariel.sfranco@gmail.com");
        Client c2 = new Client(null, "Jonata", "Salvador", "Cliente", "75 9 91796995", "ariel.sfranco@gmail.com");
        userRepository.saveAll(Arrays.asList(u1,u2));
        productRepository.saveAll(Arrays.asList(p1,p2));
        clientRepository.saveAll(Arrays.asList(c1,c2));
    }


}
