package org.unibl.etf.ip.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.spring.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

}
