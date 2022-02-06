package org.unibl.etf.ip.dto;

import java.io.Serializable;

public class LocationDTO implements Serializable {

	private static final long serialVersionUID = 2540297602533904422L;

	private int ID;
	private String Country, ISO2, ISO3, City;
	
	public LocationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocationDTO(int iD, String country, String iSO2, String iSO3, String city) {
		super();
		ID = iD;
		Country = country;
		ISO2 = iSO2;
		ISO3 = iSO3;
		City = city;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getISO2() {
		return ISO2;
	}

	public void setISO2(String iSO2) {
		ISO2 = iSO2;
	}

	public String getISO3() {
		return ISO3;
	}

	public void setISO3(String iSO3) {
		ISO3 = iSO3;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	@Override
	public String toString() {
		return "LocationDTO [ID=" + ID + ", Country=" + Country + ", ISO2=" + ISO2 + ", ISO3=" + ISO3 + ", City=" + City
				+ "]";
	}
	
	
}
