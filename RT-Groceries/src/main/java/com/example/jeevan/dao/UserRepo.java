package com.example.jeevan.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.jeevan.entity.User;

public interface UserRepo extends CrudRepository<User, Long> {

}
