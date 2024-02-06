package com.example.jeevan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jeevan.entity.Groceries;

public interface GroceriesRepository extends JpaRepository<Groceries, Integer>{

}
