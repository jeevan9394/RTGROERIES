package com.example.jeevan.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Order { 

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "consultant_id")
	private Consultant consultant;

	@ManyToOne
	@JoinColumn(name = "status")
	private GroceriesCategories groceriescategories;

	//private Integer ConsultantId;
	//private Integer status;
	private Date createdDate;
	private Date updatedDate;
	private Integer createdBy;
	private Integer updatedBy;

}
