package com.example.jeevan.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jeevan.entity.OrderDetails;
import com.example.jeevan.services.OrderDetailsService;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @PostMapping("/add")
    public ResponseEntity<OrderDetails> addOrderDetails(@RequestBody OrderDetails orderDetails) {
        OrderDetails addedOrderDetails = orderDetailsService.addOrderDetails(orderDetails);
        return new ResponseEntity<>(addedOrderDetails, HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsService.getAllOrderDetails();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderDetails> getOrderDetailsById(@PathVariable Long id) {
        Optional<OrderDetails> orderDetailsOptional = orderDetailsService.getOrderDetailsById(id);

        return orderDetailsOptional.map(orderDetails -> new ResponseEntity<>(orderDetails, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update")
    public ResponseEntity<OrderDetails> updateOrderDetails(@RequestBody OrderDetails orderDetails) {
        Optional<OrderDetails> updatedOrderDetails = orderDetailsService.updateOrderDetails(orderDetails);

        return updatedOrderDetails.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrderDetails(@PathVariable Long id) {
        if (orderDetailsService.deleteOrderDetails(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
