package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.FlightDTO;
import org.unibl.etf.ip.dto.LocationDTO;
public class FlightDAO {

	private static final String SELECT = "SELECT * FROM flight";
	private static final String SELECT_ID = "SELECT * FROM flight where ID=?";
	private static final String INSERT = "INSERT INTO flight (Seats_number, Type, Status, START_LOCATION_ID, END_LOCATION_ID) VALUES (?, ?, ?, ?, ?)";
	private static final String DELETE = "DELETE from flight WHERE ID=?";

	public static ArrayList<FlightDTO> getAllFlights() {
		ArrayList<FlightDTO> flights = new ArrayList<>();
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT);
			// stmt.setObject(1, datum);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LocationDTO startLocation = LocationDAO.getLocationByID(rs.getInt(7));
				LocationDTO endLocation = LocationDAO.getLocationByID(rs.getInt(8));
				// flights.add(new FlightDTO(rs.getInt(1), rs.getString(5), rs.getString(6),
				// startLocation, endLocation));
				flights.add(new FlightDTO(rs.getInt(1), rs.getInt(2), rs.getInt(7), rs.getInt(8), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), startLocation,endLocation));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}

		return flights;
	}

	public static FlightDTO getFlightByID(int ID) {
		FlightDTO flight = null;
		;
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ID);
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {

				//FlightScheduleDTO flightSchedules = FlightScheduleDAO.getAllSchedulesByFlightId(rs.getInt(1));
				// flights.add(new FlightDTO(rs.getInt(1), rs.getString(5), rs.getString(6),
				// startLocation, endLocation));
				flight = new FlightDTO(rs.getInt(1), rs.getInt(2), rs.getInt(7), rs.getInt(8), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}

		return flight;
	}
	public static boolean insertFlight(FlightDTO flight) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
			stmt.setInt(1, flight.getSeats_Number());
			stmt.setString(2, flight.getType());
			stmt.setString(3, flight.getStatus());
			stmt.setInt(4, flight.getStart_Location_ID());
			stmt.setInt(5, flight.getEnd_Location_ID());
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
	

	public static boolean deleteFlight(int id) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, id);
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
