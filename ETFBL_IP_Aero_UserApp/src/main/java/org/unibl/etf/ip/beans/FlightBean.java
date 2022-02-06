package org.unibl.etf.ip.beans;

import java.io.Serializable;
import java.util.ArrayList;

import org.unibl.etf.ip.dao.FlightDAO;
import org.unibl.etf.ip.dto.FlightDTO;

public class FlightBean implements Serializable {

	private static final long serialVersionUID = 1048741036372003622L;

	public FlightBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<FlightDTO> getAllFlights(){
		return FlightDAO.getAllFlights();
	}
}
