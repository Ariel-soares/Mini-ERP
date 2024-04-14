package com.arielSoares.WebSystem.services;

import com.arielSoares.WebSystem.entities.Order;
import com.arielSoares.WebSystem.entities.Product;
import com.arielSoares.WebSystem.entities.enums.OrderStatus;
import com.arielSoares.WebSystem.mail.Email;
import com.arielSoares.WebSystem.mail.mailService.mailService;
import com.arielSoares.WebSystem.repositories.OrderRepository;
import com.arielSoares.WebSystem.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private com.arielSoares.WebSystem.mail.mailService.mailController mailController;
    @Autowired
    private mailService mailService;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

    public Order update(Long id, Order obj){
        try {
            Order order = repository.getReferenceById(id);
            updateData(order, obj);
            if (order.getOrderStatus() == OrderStatus.PAID){
                try {
                    mailController.sendMail(new Email("ariel.sfranco@gmail.com", "Pedido finalizado", "Obrigado por comprar conosco"), mailService);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
            return repository.save(order);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Order order, Order obj) {
        order.setMoment(obj.getMoment());
        order.setOrderStatus(obj.getOrderStatus());
    }

    public Order insert(Order obj){
        return repository.save(obj);
    }
}
