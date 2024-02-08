package com.example.jeevan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jeevan.dao.OrderDetailsRepo;
import com.example.jeevan.entity.OrderDetails;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepo orderDetailsRepo;

    @Autowired
    public OrderDetailsService(OrderDetailsRepo orderDetailsRepository) {
        this.orderDetailsRepo = orderDetailsRepository;
    }

    public OrderDetails addOrderDetails(OrderDetails orderDetails) {
        // Perform any additional business logic if needed
        return orderDetailsRepo.save(orderDetails);
    }

    public List<OrderDetails> getAllOrderDetails() {
        return (List<OrderDetails>) orderDetailsRepo.findAll();
    }

    public Optional<OrderDetails> getOrderDetailsById(Long id) {
        return orderDetailsRepo.findById(id);
    }

    public Optional<OrderDetails> updateOrderDetails(OrderDetails orderDetails) {
        // Check if the orderDetails with the given ID exists
        return orderDetailsRepo.findById(orderDetails.getId())
                .map(existingOrderDetails -> {
                    // Update fields as needed
                    existingOrderDetails.setOrderId(orderDetails.getOrderId());
                    existingOrderDetails.setGroceriesId(orderDetails.getGroceriesId());
                    existingOrderDetails.setQuantity(orderDetails.getQuantity());
                    existingOrderDetails.setMeasure(orderDetails.getMeasure());
                    existingOrderDetails.setStatus(orderDetails.getStatus());
                    return orderDetailsRepo.save(existingOrderDetails);
                });
    }

    public boolean deleteOrderDetails(Long id) {
        // Check if the orderDetails with the given ID exists
        if (orderDetailsRepo.existsById(id)) {
            orderDetailsRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}