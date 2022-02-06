package org.unibl.etf.ip.spring.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.spring.entities.ScheduleFlight;
import org.unibl.etf.ip.spring.repositories.ScheduleFlightRepository;

@Service
public class ScheduleFlightService {

	@Autowired
	private ScheduleFlightRepository scheduleFlightRepository;
	
	public List<ScheduleFlight> getAll(){
		return scheduleFlightRepository.findAll();
	}

	
	public ScheduleFlight add(@Valid ScheduleFlight schFlg) {
		return scheduleFlightRepository.save(schFlg);
	}
}
