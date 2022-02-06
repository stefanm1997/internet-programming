package org.unibl.etf.ip.spring.contorllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.spring.entities.Schedule;
import org.unibl.etf.ip.spring.entities.ScheduleFlight;
import org.unibl.etf.ip.spring.services.ScheduleFlightService;
import org.unibl.etf.ip.spring.services.ScheduleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/scheduleflight")
public class ScheduleFlightController {

	@Autowired
	private ScheduleFlightService service;
	
	@GetMapping
	public ResponseEntity<List<ScheduleFlight>> getAll() {
		List<ScheduleFlight> schedule = service.getAll();
		if(!schedule.isEmpty())
			return ResponseEntity.ok(schedule);
		else 
			return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody ScheduleFlight scheFlght) {	
		try {
//			if(schedule == null || schedule.getDate()==null || schedule.getDay()==null || schedule.getHour()==null) {
//				return ResponseEntity.badRequest().body("Unable to create schedule!");
//			}
			System.out.println(scheFlght.getFLIGHT_ID()+"///////////"+scheFlght.getSCHEDULE_ID());
			ScheduleFlight schdlFlgh = service.add(scheFlght);
			
			return new ResponseEntity<ScheduleFlight>(schdlFlgh, HttpStatus.CREATED);
		} catch (Exception e) {
			System.err.println(e);
			return ResponseEntity.badRequest().body("Exception in body request!");
			//return new ResponseEntity<Message>(HttpStatus.BAD_REQUEST);
		}
	}
}
