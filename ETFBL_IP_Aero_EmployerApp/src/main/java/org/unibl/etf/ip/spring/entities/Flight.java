package org.unibl.etf.ip.spring.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "Seats_number")
	private int Seats_number;
	
	@Column(name = "Cargo_description")
	private String  Cargo_description;
	
	@Column(name = "Specification_file")
	private String Specification_file;
	
	@Column(name = "Type")
	private String Type;
	
	@Column(name = "Status")
	private String Status;
	
	@OneToOne
	@JoinColumn(name = "START_LOCATION_ID")
	private Location Start_location;
	
	@OneToOne
	@JoinColumn(name = "END_LOCATION_ID")
	private Location End_location;
	
	@ManyToMany
	private List<Schedule> schedule;

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getSeats_number() {
		return Seats_number;
	}

	public void setSeats_number(int seats_number) {
		Seats_number = seats_number;
	}

	public String getCargo_description() {
		return Cargo_description;
	}

	public void setCargo_description(String cargo_description) {
		Cargo_description = cargo_description;
	}

	public String getSpecification_file() {
		return Specification_file;
	}

	public void setSpecification_file(String specification_file) {
		Specification_file = specification_file;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Location getStart_location() {
		return Start_location;
	}

	public void setStart_location(Location start_location) {
		Start_location = start_location;
	}

	public Location getEnd_location() {
		return End_location;
	}

	public void setEnd_location(Location end_location) {
		End_location = end_location;
	}

	public List<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Schedule> schedule) {
		this.schedule = schedule;
	}
	
	
}
