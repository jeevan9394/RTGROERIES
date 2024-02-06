package com.example.jeevan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jeevan.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    // You can add custom queries here if needed
}
