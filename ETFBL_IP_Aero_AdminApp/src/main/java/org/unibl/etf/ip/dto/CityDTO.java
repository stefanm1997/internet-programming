package org.unibl.etf.ip.dto;

import java.io.Serializable;

public class CityDTO implements Serializable {

	private static final long serialVersionUID = 7047947881879834663L;

	private int ID, ID_Country;
	private String Name;
	private double Population;

	public CityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CityDTO(int iD, int iD_Country, String name, double population) {
		super();
		ID = iD;
		ID_Country = iD_Country;
		Name = name;
		Population = population;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID_Country() {
		return ID_Country;
	}

	public void setID_Country(int iD_Country) {
		ID_Country = iD_Country;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getPopulation() {
		return Population;
	}

	public void setPopulation(double population) {
		Population = population;
	}

	@Override
	public String toString() {
		return "CityDAO [ID=" + ID + ", ID_Country=" + ID_Country + ", Name=" + Name + ", Population=" + Population
				+ "]";
	}

}
