package com.arielSoares.WebSystem.repositories;

import com.arielSoares.WebSystem.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
