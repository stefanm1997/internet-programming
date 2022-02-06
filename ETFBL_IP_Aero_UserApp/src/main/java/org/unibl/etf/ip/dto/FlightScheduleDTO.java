package org.unibl.etf.ip.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class FlightScheduleDTO implements Serializable {

	private static final long serialVersionUID = 8360553481590814941L;
	
	private int flightID;
	private ArrayList<ScheduleDTO> scheduleList = new ArrayList<ScheduleDTO>();
	
	public FlightScheduleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightScheduleDTO(int flightID, ArrayList<ScheduleDTO> scheduleList) {
		super();
		this.flightID = flightID;
		this.scheduleList = scheduleList;
	}

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public ArrayList<ScheduleDTO> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(ArrayList<ScheduleDTO> scheduleList) {
		this.scheduleList = scheduleList;
	}

	@Override
	public String toString() {
		return "FlightScheduleDTO [flightID=" + flightID + ", scheduleList=" + scheduleList + "]";
	}
	
}
