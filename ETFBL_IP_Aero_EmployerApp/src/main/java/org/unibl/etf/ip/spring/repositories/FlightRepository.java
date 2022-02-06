package org.unibl.etf.ip.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.spring.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{

}
