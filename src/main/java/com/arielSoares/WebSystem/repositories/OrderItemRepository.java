package com.arielSoares.WebSystem.repositories;

import com.arielSoares.WebSystem.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
}
