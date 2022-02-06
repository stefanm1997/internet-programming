package org.unibl.etf.ip.spring.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.spring.entities.Schedule;
import org.unibl.etf.ip.spring.repositories.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public List<Schedule> getAllSchedules(){
		return scheduleRepository.findAll();
	}
	
	public Schedule getScheduleById(Long id) {
		return scheduleRepository.findById(id).get();
	}
	
	public Schedule addSchedule(@Valid Schedule schedule) {
		return scheduleRepository.save(schedule);
	}
	
	public Schedule updateSchedule(@Valid Schedule schedule) {
		return scheduleRepository.save(schedule);
	}
	
	public void deleteSchedule(Long id) {
		scheduleRepository.deleteById(id);
	}
}
