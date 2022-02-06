package org.unibl.etf.ip.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "Country")
	private String Country;
	
	@Column(name = "ISO2")
	private String ISO2;
	
	@Column(name = "ISO3")
	private String ISO3;
	
	@Column(name = "City")
	private String City;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
	
}
