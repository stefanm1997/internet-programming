package org.unibl.etf.ip.dto;

import java.io.Serializable;

public class ScheduleDTO implements Serializable {

	private static final long serialVersionUID = -7464096385108725L;

	private int ID;
	private String Date,Day,Hour;
	
	public ScheduleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScheduleDTO(int iD, String date, String day, String hour) {
		super();
		ID = iD;
		Date = date;
		Day = day;
		Hour = hour;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getDay() {
		return Day;
	}

	public void setDay(String day) {
		Day = day;
	}

	public String getHour() {
		return Hour;
	}

	public void setHour(String hour) {
		Hour = hour;
	}

	@Override
	public String toString() {
		return "ScheduleDTO [ID=" + ID + ", Date=" + Date + ", Day=" + Day + ", Hour=" + Hour + "]";
	}
	
	
}
