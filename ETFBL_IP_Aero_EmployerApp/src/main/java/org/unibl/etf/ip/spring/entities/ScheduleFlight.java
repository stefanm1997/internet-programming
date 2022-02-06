package org.unibl.etf.ip.spring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "flight_schedule")
@IdClass(ScheduleFlightId.class)
public class ScheduleFlight {
	
	@Id
	private Long SCHEDULE_ID;

	@Id
	private Long FLIGHT_ID;

	public ScheduleFlight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScheduleFlight(Long sCHEDULE_ID, Long fLIGHT_ID) {
		SCHEDULE_ID = sCHEDULE_ID;
		FLIGHT_ID = fLIGHT_ID;
	}

	public Long getSCHEDULE_ID() {
		return SCHEDULE_ID;
	}

	public void setSCHEDULE_ID(Long sCHEDULE_ID) {
		SCHEDULE_ID = sCHEDULE_ID;
	}

	public Long getFLIGHT_ID() {
		return FLIGHT_ID;
	}

	public void setFLIGHT_ID(Long fLIGHT_ID) {
		FLIGHT_ID = fLIGHT_ID;
	}
	
}
