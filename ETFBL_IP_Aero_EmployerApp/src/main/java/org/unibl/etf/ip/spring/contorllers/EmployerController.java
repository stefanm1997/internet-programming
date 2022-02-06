package org.unibl.etf.ip.spring.contorllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.spring.entities.Employer;
import org.unibl.etf.ip.spring.services.EmployerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/employer")
public class EmployerController {

	@Autowired
	private EmployerService service;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Employer employer) {
		try {
			if (employer == null || employer.getPassword() == null || employer.getUsername() == null) {
				return ResponseEntity.badRequest().body("Unable to login! Username or password was empty!");
			}
			List<Employer> employers = service.getAllEmployers();
			for (Employer empl : employers) {
				if(empl.getUsername().equals(employer.getUsername()) && empl.getPassword().equals(employer.getPassword())) {
					return new ResponseEntity<Employer>(empl, HttpStatus.OK);
				}
			}
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Exception in body request!");
			// return new ResponseEntity<Message>(HttpStatus.BAD_REQUEST);
		}
	}
}
