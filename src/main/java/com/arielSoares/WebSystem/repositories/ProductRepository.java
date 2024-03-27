package com.arielSoares.WebSystem.repositories;

import com.arielSoares.WebSystem.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
