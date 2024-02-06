package com.example.jeevan.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.jeevan.dao.ConsultantRepository;
import com.example.jeevan.entity.Consultant;

@org.springframework.stereotype.Service
public class ConsultantService {
	@Autowired
	ConsultantRepository repository;

	public Consultant saveConsultant(Consultant consultant) {
		return repository.save(consultant);
	}

	public List<Consultant> getConsultant() {
		List<Consultant> Consultants = (List<Consultant>) this.repository.findAll();
		return Consultants;
	}

	public Consultant getConsultantById(int id) {
		java.util.Optional<Consultant> optionalConsultant = repository.findById(id);
		return optionalConsultant.get();
	}

	public void deleteConsultant(int id) {
		repository.deleteById(id);

	}

}
