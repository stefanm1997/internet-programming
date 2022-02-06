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
import org.unibl.etf.ip.spring.entities.Flight;
import org.unibl.etf.ip.spring.services.FlightService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/flight")
public class FlightController {

	@Autowired
	private FlightService service;

	@GetMapping
	public ResponseEntity<List<Flight>> getAllFlights() {
		List<Flight> flights = service.getAllFlights();
		if (!flights.isEmpty())
			return ResponseEntity.ok(flights);
		else
			return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getFlightById(@PathVariable Long id) {
		try {
			Flight flight = service.getFlightByID(id);
			return new ResponseEntity<Flight>(flight, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body("Unable to find flight with id: " + id);
		}
	}

	@PostMapping
	public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
		try {
			if (flight == null || flight.getSeats_number() == 0 || flight.getType() == null
					|| flight.getStatus() == null || flight.getStart_location() == null
					|| flight.getEnd_location() == null) {
				return ResponseEntity.badRequest().body("Unable to create flight!");
			}
			Flight flght = service.addFlight(flight);
			return new ResponseEntity<Flight>(flght, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Unable to find flight in body request!");
			// return new ResponseEntity<Message>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateFlight(@RequestBody Flight flight, @PathVariable Long id) {
		try {
			if (flight == null || flight.getSeats_number() == 0 || flight.getType() == null
					|| flight.getStatus() == null || flight.getStart_location() == null
					|| flight.getEnd_location() == null) {
				return ResponseEntity.badRequest().body("Unable to update flight!");
			}
			service.getFlightByID(id);
			flight.setId(id);
			service.updateFlight(flight);
			return new ResponseEntity<Flight>(flight, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body("Unable to find flight with id:" + id);
			// return new ResponseEntity<Message>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFlight(@PathVariable Long id) {
		try {
			service.deleteFlight(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.badRequest().body("Unable to delete flight with id: " + id);
			// return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
		}
	}
}
