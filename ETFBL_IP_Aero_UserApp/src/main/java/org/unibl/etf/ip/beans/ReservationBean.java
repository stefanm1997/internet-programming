package org.unibl.etf.ip.beans;

import java.io.Serializable;
import java.util.ArrayList;

import org.unibl.etf.ip.dao.ReservationDAO;
import org.unibl.etf.ip.dto.ReservationDTO;

public class ReservationBean implements Serializable {

	private static final long serialVersionUID = 556506185238355380L;

	public ReservationBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ReservationDTO> getAllReservations(){
		return ReservationDAO.getAllReservations();
	}
	
	public boolean addReservation(ReservationDTO reservation) {
		if(reservation != null && reservation.getDate_creation() != null) {
			ReservationDAO.insertReservation(reservation);
			return true;
		}
		return false;
	}
}
