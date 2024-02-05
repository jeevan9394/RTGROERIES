package com.example.jeevan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jeevan.Entity.Groceries;
import com.example.jeevan.dao.GroceriesRepository;

@Service
public class GroceriesService {

    @Autowired
    private GroceriesRepository groceriesRepository;

    public List<Groceries> getAllGroceries() {
        return groceriesRepository.findAll();
    }

    public Optional<Groceries> getGroceriesById(Integer id) {
        return groceriesRepository.findById(id);
    }

    public Groceries saveGroceries(Groceries groceries) {
        return groceriesRepository.save(groceries);
    }

    public void deleteGroceries(Integer id) {
        groceriesRepository.deleteById(id);
    }
}

