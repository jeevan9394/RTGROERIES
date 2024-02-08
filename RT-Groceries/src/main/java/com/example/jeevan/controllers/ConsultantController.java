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

import com.example.jeevan.entity.Consultant;
import com.example.jeevan.services.ConsultantService;

@RestController
@RequestMapping("/api")
public class ConsultantController {

	@Autowired
	ConsultantService service; 

	@GetMapping("/consultants")
	public List<Consultant> getConsultant() {
		return this.service.getConsultant(); 
	}

	@PostMapping("/saveConsultant")
	public Consultant saveConsultant(@RequestBody Consultant consultant) {
		return service.saveConsultant(consultant);
	}

	@PutMapping("/updateConsultant/{id}")
	public ResponseEntity<Consultant> updateConsultant(@PathVariable int id,
			@RequestBody Consultant updatedConsultant)
	{
		Consultant existingConsultant = service.getConsultantById(id);

		existingConsultant.setPhoneNumber(updatedConsultant.getPhoneNumber());
		existingConsultant.setName(updatedConsultant.getName());
		existingConsultant.setRoomNumber(updatedConsultant.getRoomNumber());
		existingConsultant.setApartmentName(updatedConsultant.getApartmentName());

		Consultant updatedConsultantEntity = service.saveConsultant(existingConsultant);

		return new ResponseEntity<>(updatedConsultantEntity, HttpStatus.OK);
	}
	
	 @DeleteMapping("/deleteConsultant/{id}")
	    public ResponseEntity<Void> deleteConsultant(@PathVariable int id) {
	        Consultant existingConsultant = service.getConsultantById(id);

	        if (existingConsultant != null) 
	        {
	           this.service.deleteConsultant(id);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	
}
