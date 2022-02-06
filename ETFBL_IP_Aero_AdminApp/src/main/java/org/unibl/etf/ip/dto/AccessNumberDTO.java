package org.unibl.etf.ip.dto;

import java.io.Serializable;

public class AccessNumberDTO implements Serializable {

	private static final long serialVersionUID = -3863717447084031624L;

	private int ID, Number;
	private String Date;
	
	public AccessNumberDTO() {
		super();
	}

	public AccessNumberDTO(int iD, int number, String date) {
		super();
		ID = iD;
		Number = number;
		Date = date;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	@Override
	public String toString() {
		return "AccessNumberDTO [ID=" + ID + ", Number=" + Number + ", Date=" + Date + "]";
	}
	
	
}
