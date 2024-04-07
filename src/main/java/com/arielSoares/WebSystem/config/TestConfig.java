package com.arielSoares.WebSystem.config;

import com.arielSoares.WebSystem.entities.*;
import com.arielSoares.WebSystem.entities.enums.OrderStatus;
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
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "ariel", "ariel.sfranco@gmail.com", true, "Ariel","123");
        User u2 = new User(null, "Jonata", "jonata@gmail.com", true, "Jonata","123");

        Client c1 = new Client(null, "ariel", "Salvador", "Cliente", "75 9 91796995", "ariel.sfranco@gmail.com");
        Client c2 = new Client(null, "Jonata", "Salvador", "Cliente", "75 9 91796995", "ariel.sfranco@gmail.com");

        Category cat1 = new Category(null, "vidros", "Setor destinado a artigos de vidraçaria");
        Category cat2 = new Category(null, "Copos", "Setor direcionado a artigos de serigrafia de copos");

        Product p1 = new Product(null, "Box", "Box de vidro", 300.00);
        Product p2 = new Product(null, "Copo Stanley", "Copo para serigrafia", 200.00);

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07z"), c1, OrderStatus.PAID);

        categoryRepository.saveAll(Arrays.asList(cat1,cat2));
        userRepository.saveAll(Arrays.asList(u1,u2));
        productRepository.saveAll(Arrays.asList(p1,p2));
        clientRepository.saveAll(Arrays.asList(c1,c2));
        orderRepository.save(o1);

        p1.getCategories().add(cat1);
        p2.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());

        orderItemRepository.save(oi1);

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07z"), o1);

        o1.setPayment(pay1);

        orderRepository.save(o1);
    }
}