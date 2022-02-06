package org.unibl.etf.ip.dto;

import java.io.Serializable;

public class FlightDTO implements Serializable {

	private static final long serialVersionUID = 1293085104080166942L;
	
	private int ID,Seats_Number,Start_Location_ID,End_Location_ID;
	private String Description,File,Type,Status;
	private LocationDTO startLocation, endLocation;
	
	public FlightDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightDTO(int iD, int seats_Number, int start_Location_ID, int end_Location_ID, String description,
			String file, String type, String status) {
		super();
		ID = iD;
		Seats_Number = seats_Number;
		Start_Location_ID = start_Location_ID;
		End_Location_ID = end_Location_ID;
		Description = description;
		File = file;
		Type = type;
		Status = status;
	}
	
	

	public FlightDTO(int iD, String type, String status, LocationDTO startLocation, LocationDTO endLocation) {
		super();
		ID = iD;
		Type = type;
		Status = status;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}
	
	

	public FlightDTO(int iD, int seats_Number, int start_Location_ID, int end_Location_ID, String description,
			String file, String type, String status, LocationDTO startLocation, LocationDTO endLocation) {
		super();
		ID = iD;
		Seats_Number = seats_Number;
		Start_Location_ID = start_Location_ID;
		End_Location_ID = end_Location_ID;
		Description = description;
		File = file;
		Type = type;
		Status = status;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getSeats_Number() {
		return Seats_Number;
	}

	public void setSeats_Number(int seats_Number) {
		Seats_Number = seats_Number;
	}

	public int getStart_Location_ID() {
		return Start_Location_ID;
	}

	public void setStart_Location_ID(int start_Location_ID) {
		Start_Location_ID = start_Location_ID;
	}

	public int getEnd_Location_ID() {
		return End_Location_ID;
	}

	public void setEnd_Location_ID(int end_Location_ID) {
		End_Location_ID = end_Location_ID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getFile() {
		return File;
	}

	public void setFile(String file) {
		File = file;
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

	public LocationDTO getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(LocationDTO startLocation) {
		this.startLocation = startLocation;
	}

	public LocationDTO getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(LocationDTO endLocation) {
		this.endLocation = endLocation;
	}

	@Override
	public String toString() {
		return "FlightDTO [ID=" + ID + ", Seats_Number=" + Seats_Number + ", Start_Location_ID=" + Start_Location_ID
				+ ", End_Location_ID=" + End_Location_ID + ", Description=" + Description + ", File=" + File + ", Type="
				+ Type + ", Status=" + Status + ", startLocation=" + startLocation + ", endLocation=" + endLocation
				+ "]";
	}

	
	
}
