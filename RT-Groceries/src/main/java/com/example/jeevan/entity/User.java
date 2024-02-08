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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	private String Username;
	private String password;
	@ManyToOne
	@JoinColumn(name = "userTypeName")
	private UserType usertype;
	private Date createdDate;
	private Date updatedDate;
	private Integer createdBy;
	private Integer updatedBy;

}
