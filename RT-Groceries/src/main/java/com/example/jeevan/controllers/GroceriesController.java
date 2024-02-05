package com.example.jeevan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.jeevan.Entity.Groceries;
import com.example.jeevan.services.GroceriesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groceries")
public class GroceriesController {

    @Autowired
    private GroceriesService groceriesService;

    @GetMapping("/all")
    public List<Groceries> getAllGroceries() {
        return groceriesService.getAllGroceries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Groceries> getGroceriesById(@PathVariable Integer id) {
        Optional<Groceries> groceries = groceriesService.getGroceriesById(id);
        return groceries.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Groceries> saveGroceries(@RequestBody Groceries groceries) {
        Groceries savedGroceries = groceriesService.saveGroceries(groceries);
        return new ResponseEntity<>(savedGroceries, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Groceries> updateGroceries(@PathVariable Integer id, @RequestBody Groceries updatedGroceries) {
        Optional<Groceries> existingGroceries = groceriesService.getGroceriesById(id);

        if (existingGroceries.isPresent()) {
            
            existingGroceries.get().setItemName(updatedGroceries.getItemName());
            existingGroceries.get().setItemQuantity(updatedGroceries.getItemQuantity());
            existingGroceries.get().setItemType(updatedGroceries.getItemType());

            
            Groceries updatedGroceriesEntity = groceriesService.saveGroceries(existingGroceries.get());

            return new ResponseEntity<>(updatedGroceriesEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceries(@PathVariable Integer id) {
        Optional<Groceries> existingGroceries = groceriesService.getGroceriesById(id);

        if (existingGroceries.isPresent()) {
            groceriesService.deleteGroceries(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
