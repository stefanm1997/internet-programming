package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.LocationDTO;

public class LocationDAO {

	private static final String SELECT = "SELECT * FROM location";
	private static final String INSERT = "INSERT INTO location (Country, ISO2, ISO3, City) VALUES (?, ?, ?, ?)";
	private static final String DELETE = "DELETE from location WHERE id=?";
	private static final String UPDATE = "UPDATE location SET Country=?, ISO2=?, ISO3=?, City=? WHERE id=?";
	private static final String SELECT_BY_ID = "SELECT * FROM location where ID=?";
	
	public static ArrayList<LocationDTO> getAllLocations() {
		ArrayList<LocationDTO> locations = new ArrayList<>();
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT);
			// stmt.setObject(1, datum);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				locations.add(new LocationDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		return locations;
	}
	
	public static LocationDTO getLocationByID(int ID) {
		LocationDTO location = null;
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				location =new LocationDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}else {
				System.out.println("Nema elementa!");
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		return location;
	}

	public static boolean insertLocation(LocationDTO location) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, location.getCountry());
			stmt.setString(2, location.getISO2());
			stmt.setString(3, location.getISO3());
			stmt.setString(4, location.getCity());
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

	public static boolean deleteLocation(int id) {
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

	public static boolean updateLocation(LocationDTO location, int id) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, location.getCountry());
			stmt.setString(2, location.getISO2());
			stmt.setString(3, location.getISO3());
			stmt.setString(4, location.getCity());
			stmt.setInt(5, id);
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
