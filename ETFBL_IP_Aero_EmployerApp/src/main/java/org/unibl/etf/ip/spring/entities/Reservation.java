package org.unibl.etf.ip.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long Id;
	
	@Column(name = "Status")
	private String Status;
	
	@Column(name = "Date_creation")
	private String Date_creation;
	
	@Column(name = "Reason")
	private String Reason;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User User;
	
	@ManyToOne
	@JoinColumn(name = "FLIGHT_ID")
	private Flight Flight;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public Flight getFlight() {
		return Flight;
	}

	public void setFlight(Flight flight) {
		Flight = flight;
	}
	
}
