package org.unibl.etf.ip.spring.entities;

import java.io.Serializable;

public class ScheduleFlightId implements Serializable{

	private static final long serialVersionUID = -4843950270951947522L;

	private Long SCHEDULE_ID;

	private Long FLIGHT_ID;
	
	public ScheduleFlightId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScheduleFlightId(Long sCHEDULE_ID, Long fLIGHT_ID) {
		SCHEDULE_ID = sCHEDULE_ID;
		FLIGHT_ID = fLIGHT_ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FLIGHT_ID == null) ? 0 : FLIGHT_ID.hashCode());
		result = prime * result + ((SCHEDULE_ID == null) ? 0 : SCHEDULE_ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduleFlightId other = (ScheduleFlightId) obj;
		if (FLIGHT_ID == null) {
			if (other.FLIGHT_ID != null)
				return false;
		} else if (!FLIGHT_ID.equals(other.FLIGHT_ID))
			return false;
		if (SCHEDULE_ID == null) {
			if (other.SCHEDULE_ID != null)
				return false;
		} else if (!SCHEDULE_ID.equals(other.SCHEDULE_ID))
			return false;
		return true;
	}
	
	
}
