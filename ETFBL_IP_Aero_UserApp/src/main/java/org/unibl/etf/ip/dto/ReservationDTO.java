package org.unibl.etf.ip.dto;

import java.io.Serializable;

public class ReservationDTO implements Serializable {

	private static final long serialVersionUID = -6516752923166159593L;

	private int ID,USER_ID,FLIGHT_ID;
	private String Status,Date_creation,Reason;
	private UserDTO user;
	private FlightDTO flight;
	
	public ReservationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReservationDTO(int iD, int uSER_ID, int fLIGHT_ID, String status, String date_creation, String reason,
			UserDTO user, FlightDTO flight) {
		super();
		ID = iD;
		USER_ID = uSER_ID;
		FLIGHT_ID = fLIGHT_ID;
		Status = status;
		Date_creation = date_creation;
		Reason = reason;
		this.user = user;
		this.flight = flight;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}

	public int getFLIGHT_ID() {
		return FLIGHT_ID;
	}

	public void setFLIGHT_ID(int fLIGHT_ID) {
		FLIGHT_ID = fLIGHT_ID;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getDate_creation() {
		return Date_creation;
	}

	public void setDate_creation(String date_creation) {
		Date_creation = date_creation;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public FlightDTO getFlight() {
		return flight;
	}

	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "ReservationDTO [ID=" + ID + ", USER_ID=" + USER_ID + ", FLIGHT_ID=" + FLIGHT_ID + ", Status=" + Status
				+ ", Date_creation=" + Date_creation + ", Reason=" + Reason + ", user=" + user + ", flight=" + flight
				+ "]";
	}
}
