package com.arielSoares.WebSystem.services;

import com.arielSoares.WebSystem.entities.Client;
import com.arielSoares.WebSystem.entities.Product;
import com.arielSoares.WebSystem.entities.User;
import com.arielSoares.WebSystem.repositories.ProductRepository;
import com.arielSoares.WebSystem.repositories.UserRepository;
import com.arielSoares.WebSystem.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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

    public Product update(Long id, Product obj){
        try {
            Product product = repository.getReferenceById(id);
            updateData(product, obj);
            return repository.save(product);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product product, Product obj) {
        product.setName(obj.getName());
        product.setDescription(obj.getDescription());
        product.setPrice(obj.getPrice());
    }

}
