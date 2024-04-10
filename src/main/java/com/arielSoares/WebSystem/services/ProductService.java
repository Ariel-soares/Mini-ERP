package com.arielSoares.WebSystem.services;

import com.arielSoares.WebSystem.entities.Product;
import com.arielSoares.WebSystem.entities.User;
import com.arielSoares.WebSystem.repositories.ProductRepository;
import com.arielSoares.WebSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    public Product insert(Product product){
        return repository.save(product);
    }

}
