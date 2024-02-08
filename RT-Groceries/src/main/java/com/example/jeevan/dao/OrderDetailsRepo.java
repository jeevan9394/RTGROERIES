package com.example.jeevan.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.jeevan.entity.OrderDetails;

public interface OrderDetailsRepo extends CrudRepository<OrderDetails, Long> {
	

}
