package com.example.jeevan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private Integer OrderId;
	private Integer GroceriesId;
	private Integer Quantity;
	private Integer Measure;
	private Integer Status;
	

}
