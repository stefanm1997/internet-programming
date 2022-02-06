package org.unibl.etf.ip.spring.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.spring.entities.Flight;
import org.unibl.etf.ip.spring.repositories.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flight> getAllFlights(){
		return flightRepository.findAll();
	}
	
	public Flight getFlightByID(Long id) {
		return flightRepository.findById(id).get();
	}
	
	public Flight addFlight(@Valid Flight flight) {
		return flightRepository.save(flight);
	}
	
	public Flight updateFlight(@Valid Flight flight) {
		return flightRepository.save(flight);
	}
	
	public void deleteFlight(Long id) {
		flightRepository.deleteById(id);
	}

}
