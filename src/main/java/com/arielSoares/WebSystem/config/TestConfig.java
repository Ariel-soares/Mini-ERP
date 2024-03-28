package com.arielSoares.WebSystem.config;

import com.arielSoares.WebSystem.entities.*;
import com.arielSoares.WebSystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
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

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SectorRepository sectorRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "ariel", "ariel.sfranco@gmail.com", true, "ariel","123");
        User u2 = new User(null, "Jonata", "jonata@gmail.com", true, "ariel","123");

        Client c1 = new Client(null, "ariel", "Salvador", "Cliente", "75 9 91796995", "ariel.sfranco@gmail.com");
        Client c2 = new Client(null, "Jonata", "Salvador", "Cliente", "75 9 91796995", "ariel.sfranco@gmail.com");

        Sector s1 = new Sector(null, "vidros", "Setor destinado a artigos de vidraçaria");
        Sector s2 = new Sector(null, "Copos", "Setor direcionado a artigos de serigrafia de copos");

        Product p1 = new Product(null, "Monitor", "Monitor de computador", 300.00, s1);
        Product p2 = new Product(null, "Computer", "Computer", 3000.00, s2);

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07z"), c1);

        sectorRepository.saveAll(Arrays.asList(s1,s2));
        userRepository.saveAll(Arrays.asList(u1,u2));
        productRepository.saveAll(Arrays.asList(p1,p2));
        clientRepository.saveAll(Arrays.asList(c1,c2));
        orderRepository.saveAll(Arrays.asList(o1));

    }


}
