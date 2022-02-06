package org.unibl.etf.ip.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 7777436420063535271L;
	private int ID;
	private String Email, Firstname, Lastname, Address, Country, Username, Password, Type;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int iD, String email, String firstname, String lastname, String address, String country,
			String username, String password, String type) {
		super();
		ID = iD;
		Email = email;
		Firstname = firstname;
		Lastname = lastname;
		Address = address;
		Country = country;
		Username = username;
		Password = password;
		Type = type;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", Email=" + Email + ", Firstname=" + Firstname + ", Lastname=" + Lastname
				+ ", Address=" + Address + ", Country=" + Country + ", Username=" + Username + ", Password=" + Password
				+ ", Type=" + Type + "]";
	}

}
