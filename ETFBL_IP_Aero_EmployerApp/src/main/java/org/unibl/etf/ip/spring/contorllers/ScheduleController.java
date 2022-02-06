package org.unibl.etf.ip.spring.contorllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.spring.entities.Schedule;
import org.unibl.etf.ip.spring.services.ScheduleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService service;
	
	@GetMapping
	public ResponseEntity<List<Schedule>> getAllSchedules() {
		List<Schedule> schedule = service.getAllSchedules();
		if(!schedule.isEmpty())
			return ResponseEntity.ok(schedule);
		else 
			return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getScheduleById(@PathVariable Long id) {
		try {
			Schedule schedule = service.getScheduleById(id);
			return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body("Unable to find schedule with id: "+id);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> addSchedule(@RequestBody Schedule schedule) {	
		try {
			if(schedule == null || schedule.getDate()==null || schedule.getDay()==null || schedule.getHour()==null) {
				return ResponseEntity.badRequest().body("Unable to create schedule!");
			}
			Schedule schdl = service.addSchedule(schedule);
			return new ResponseEntity<Schedule>(schdl, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Unable to find schedule in body request!");
			//return new ResponseEntity<Message>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateSchedule(@RequestBody Schedule schedule, @PathVariable Long id) {	
		try {
			if(schedule == null || schedule.getDate()==null || schedule.getDay()==null || schedule.getHour()==null) {
				return ResponseEntity.badRequest().body("Unable to update schedule!");
			}
			service.getScheduleById(id);
			schedule.setID(id);
			service.updateSchedule(schedule);
			return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body("Unable to find schedule with id:"+id);
			//return new ResponseEntity<Message>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSchedule(@PathVariable Long id){
		try {
			service.deleteSchedule(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.badRequest().body("Unable to delete schedule with id: "+id);
			//return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
		}
	}

}
