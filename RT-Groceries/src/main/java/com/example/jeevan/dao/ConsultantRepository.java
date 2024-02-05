package com.example.jeevan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jeevan.Entity.Consultant;

public interface ConsultantRepository extends JpaRepository<Consultant, Integer> {
    // You can add custom query methods if needed
}
