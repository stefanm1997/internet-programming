package org.unibl.etf.ip.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.spring.entities.Employer;
import org.unibl.etf.ip.spring.repositories.EmployerRepository;

@Service
public class EmployerService {

	@Autowired
	private EmployerRepository employerRepository;
	
	public List<Employer> getAllEmployers(){
		return employerRepository.findAll();
	}
	
}
