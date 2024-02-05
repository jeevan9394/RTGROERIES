package com.example.jeevan.dao;

import com.example.jeevan.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    // You can add custom queries here if needed
}
