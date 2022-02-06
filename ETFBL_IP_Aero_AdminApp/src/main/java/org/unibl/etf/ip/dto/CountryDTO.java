package org.unibl.etf.ip.dto;

import java.io.Serializable;

public class CountryDTO implements Serializable {

	private static final long serialVersionUID = -4653876170610034836L;
	private int ID;
	private String Name, ISO2, ISO3;
	private double Population;

	public CountryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CountryDTO(int iD, String name, String iSO2, String iSO3, double population) {
		super();
		ID = iD;
		Name = name;
		ISO2 = iSO2;
		ISO3 = iSO3;
		Population = population;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

	public double getPopulation() {
		return Population;
	}

	public void setPopulation(double population) {
		Population = population;
	}

	@Override
	public String toString() {
		return "Country [ID=" + ID + ", Name=" + Name + ", ISO2=" + ISO2 + ", ISO3=" + ISO3 + ", Population="
				+ Population + "]";
	}

}
