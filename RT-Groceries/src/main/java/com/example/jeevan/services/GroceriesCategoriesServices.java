package com.example.jeevan.services;

import com.example.jeevan.Entity.GroceriesCategories;
import com.example.jeevan.dao.GroceriesCategoriesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceriesCategoriesServices {

    @Autowired
    private GroceriesCategoriesRepository repository;

    public GroceriesCategories save(GroceriesCategories category) {
        return repository.save(category);
    }

    public List<GroceriesCategories> getAllGroceriesCategories() {
        return repository.findAll();
    }

    public Optional<GroceriesCategories> getCategoryById(Integer id) {
        return repository.findById(id);
    }

    public GroceriesCategories updateCategory(GroceriesCategories category) {
        return repository.save(category);
    }

    public void deleteCategory(Integer id) {
        repository.deleteById(id);
    }

	
}
