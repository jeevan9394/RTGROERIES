package com.example.jeevan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jeevan.entity.UserType;
import com.example.jeevan.services.UserTypeService;

@RestController
@RequestMapping("/api/user-types")
public class UserTypeController {

    private final UserTypeService userTypeService;

    @Autowired
    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping
    public ResponseEntity<List<UserType>> getAllUserTypes() {
        List<UserType> userTypes = userTypeService.getAllUserTypes();
        return new ResponseEntity<>(userTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserType> getUserTypeById(@PathVariable Integer id) {
        UserType userType = userTypeService.getUserTypeById(id);
        return new ResponseEntity<>(userType, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserType> createUserType(@RequestBody UserType userType) {
        UserType createdUserType = userTypeService.createUserType(userType);
        return new ResponseEntity<>(createdUserType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserType> updateUserType(@PathVariable Integer id, @RequestBody UserType userType) {
        UserType updatedUserType = userTypeService.updateUserType(id, userType);
        return new ResponseEntity<>(updatedUserType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserType(@PathVariable Integer id) {
        userTypeService.deleteUserType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
