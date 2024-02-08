package com.example.jeevan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jeevan.dao.UserTypeRepo;
import com.example.jeevan.entity.UserType;

@Service
public class UserTypeService {

    private final UserTypeRepo userTypeRepo;

    @Autowired
    public UserTypeService(UserTypeRepo userTypeRepo) {
        this.userTypeRepo = userTypeRepo;
    }

    public List<UserType> getAllUserTypes() {
        return (List<UserType>) userTypeRepo.findAll();
    }

    public UserType getUserTypeById(Integer id) {
        Optional<UserType> userTypeOptional = userTypeRepo.findById(id);
        return userTypeOptional.orElse(null);
    }

    public UserType createUserType(UserType userType) {
        return userTypeRepo.save(userType);
    }

    public UserType updateUserType(Integer id, UserType userType) {
        Optional<UserType> existingUserTypeOptional = userTypeRepo.findById(id);
        if (existingUserTypeOptional.isPresent()) {
            UserType existingUserType = existingUserTypeOptional.get();
            existingUserType.setUserTypeName(userType.getUserTypeName());
            return userTypeRepo.save(existingUserType);
        }
        return null;
    }

    public void deleteUserType(Integer id) {
        userTypeRepo.deleteById(id);
    }
}
