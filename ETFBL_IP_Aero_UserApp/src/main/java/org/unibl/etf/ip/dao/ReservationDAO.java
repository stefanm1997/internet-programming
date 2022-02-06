package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.FlightDTO;
import org.unibl.etf.ip.dto.ReservationDTO;
import org.unibl.etf.ip.dto.UserDTO;

public class ReservationDAO {

	private static final String SELECT = "SELECT * FROM reservation";
	private static final String UPDATE = "UPDATE reservation SET Status=? WHERE ID=?";
	private static final String INSERT = "INSERT INTO reservation (USER_ID, FLIGHT_ID, Status, Date_creation) VALUES (?, ?, ?, ?)";
	
	
	public static ArrayList<ReservationDTO> getAllReservations() {
		ArrayList<ReservationDTO> reservations = new ArrayList<>();
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT);
			// stmt.setObject(1, datum);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				UserDTO user = UserDAO.getUserByID(rs.getInt(2));
				FlightDTO flight = FlightDAO.getFlightByID(rs.getInt(3));
				//flights.add(new FlightDTO(rs.getInt(1), rs.getString(5), rs.getString(6), startLocation, endLocation));
				reservations.add(new ReservationDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), user, flight));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		
		return reservations;
	}
	
	public static boolean updateReservation(String status, int id) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, status);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
			return false;
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
	}
	
	public static boolean insertReservation(ReservationDTO reservation) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
			stmt.setInt(1, reservation.getUSER_ID());
			stmt.setInt(2, reservation.getFLIGHT_ID());
			stmt.setString(3, reservation.getStatus());
			stmt.setString(4, reservation.getDate_creation());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
			return false;
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
	}
}
