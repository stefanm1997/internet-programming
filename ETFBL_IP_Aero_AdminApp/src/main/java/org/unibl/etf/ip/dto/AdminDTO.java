package org.unibl.etf.ip.dto;

import java.io.Serializable;

public class AdminDTO implements Serializable {

	private static final long serialVersionUID = 8562499724391696288L;

	private int ID;
	private String Username, Password, Firstname, Lastname;
	private boolean isLogged;

	public AdminDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminDTO(int iD, String username, String password, String firstname, String lastname) {
		super();
		ID = iD;
		Username = username;
		Password = password;
		Firstname = firstname;
		Lastname = lastname;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	@Override
	public String toString() {
		return "AdminDTO [ID=" + ID + ", Username=" + Username + ", Password=" + Password + ", Firstname=" + Firstname
				+ ", Lastname=" + Lastname + "]";
	}

}
