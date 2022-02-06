package org.unibl.etf.ip.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.spring.entities.ScheduleFlight;
import org.unibl.etf.ip.spring.entities.ScheduleFlightId;

public interface ScheduleFlightRepository extends JpaRepository<ScheduleFlight, ScheduleFlightId>{

}
