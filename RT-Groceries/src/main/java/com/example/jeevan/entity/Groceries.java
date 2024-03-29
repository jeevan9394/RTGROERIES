 package com.example.jeevan.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Groceries {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String ItemName;
	private int ItemQuantity;
	private int ItemType;
	
	 //@Column(name = "created_date")
	    private Date createdDate;

	  //  @Column(name = "updated_date")
	    private Date updatedDate;

	  //  @Column(name = "created_by")
	    private Integer createdBy;
	    
	 //   @Column(name = "updated_by")
	    private Integer updatedBy;

	
}
