package org.unibl.etf.ip.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.spring.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
