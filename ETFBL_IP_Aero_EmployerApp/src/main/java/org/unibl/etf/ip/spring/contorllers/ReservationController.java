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
import org.unibl.etf.ip.spring.entities.Reservation;
import org.unibl.etf.ip.spring.services.ReservationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService service;
	
	@GetMapping
	public ResponseEntity<List<Reservation>> getAllReservations() {
		List<Reservation> reservations = service.getAllReservations();
		if (!reservations.isEmpty())
			return ResponseEntity.ok(reservations);
		else
			return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getReservationById(@PathVariable Long id) {
		try {
			Reservation reservation = service.getReservationById(id);
			return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body("Unable to find reservation with id: " + id);
		}
	}

	@PostMapping
	public ResponseEntity<?> addReservation(@RequestBody Reservation reservation) {
		try {
			if (reservation == null || reservation.getDate_creation() == null || reservation.getStatus() == null
					|| reservation.getFlight() == null || reservation.getUser() == null) {
				return ResponseEntity.badRequest().body("Unable to reservation flight!");
			}
			Reservation rsrvtn = service.addReservation(reservation);
			return new ResponseEntity<Reservation>(rsrvtn, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Unable to find reservation in body request!");
			// return new ResponseEntity<Message>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateReservation(@RequestBody Reservation reservation, @PathVariable Long id) {
		try {
			if (reservation == null || reservation.getDate_creation() == null || reservation.getStatus() == null
					|| reservation.getFlight() == null || reservation.getUser() == null) {
				return ResponseEntity.badRequest().body("Unable to update reservation!");
			}
			service.getReservationById(id);
			reservation.setId(id);
			service.updateReservation(reservation);
			return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body("Unable to find reservation with id:" + id);
			// return new ResponseEntity<Message>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteReservation(@PathVariable Long id) {
		try {
			service.deleteReservation(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.badRequest().body("Unable to delete reservation with id: " + id);
			// return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
		}
	}

}
