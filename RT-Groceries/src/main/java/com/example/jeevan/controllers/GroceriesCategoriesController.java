package com.example.jeevan.controllers;

import com.example.jeevan.Entity.GroceriesCategories;
import com.example.jeevan.services.GroceriesCategoriesServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class GroceriesCategoriesController {

	@Autowired
	private GroceriesCategoriesServices service;

	@PostMapping("/create")
	public ResponseEntity<GroceriesCategories> createCategory(@RequestBody GroceriesCategories category) {
		GroceriesCategories createdCategory = service.save(category);
		return ResponseEntity.ok(createdCategory);
	}

	@GetMapping("/get")
	public ResponseEntity<List<GroceriesCategories>> getAllCategories() {
		List<GroceriesCategories> categories = service.getAllGroceriesCategories();
		return ResponseEntity.ok(categories);
	}

	@GetMapping("/{id}")
	public ResponseEntity<GroceriesCategories> getCategoryById(@PathVariable Integer id) {
		Optional<GroceriesCategories> category = service.getCategoryById(id);
		return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<GroceriesCategories> updateCategory(@PathVariable Integer id,
			@RequestBody GroceriesCategories category) {
		Optional<GroceriesCategories> existingCategory = service.getCategoryById(id);
		if (existingCategory.isPresent()) {
			category.setId(id);
			GroceriesCategories updatedCategory = service.updateCategory(category);
			return ResponseEntity.ok(updatedCategory);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
		Optional<GroceriesCategories> existingCategory = service.getCategoryById(id);
		if (existingCategory.isPresent()) {
			service.deleteCategory(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
