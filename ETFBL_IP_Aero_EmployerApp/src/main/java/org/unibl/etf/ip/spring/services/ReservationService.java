package org.unibl.etf.ip.spring.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.spring.entities.Reservation;
import org.unibl.etf.ip.spring.repositories.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	public List<Reservation> getAllReservations(){
		return reservationRepository.findAll();
	}
	
	public Reservation getReservationById(Long id) {
		return reservationRepository.findById(id).get();
	}
	
	public Reservation addReservation(@Valid Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	public Reservation updateReservation(@Valid Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	public void deleteReservation(Long id) {
		reservationRepository.deleteById(id);
	}
}
