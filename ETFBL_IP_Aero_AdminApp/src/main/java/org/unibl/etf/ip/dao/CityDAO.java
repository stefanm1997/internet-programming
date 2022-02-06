package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.CityDTO;

public class CityDAO {

	private static final String SELECT = "SELECT * FROM city";
	private static final String INSERT = "INSERT INTO city (Name, Population, COUNTRY_ID) VALUES (?, ?, ?)";
	private static final String DELETE = "DELETE from city WHERE id=?";
	private static final String UPDATE = "UPDATE city SET Name=?, Population=?, COUNTRY_ID=? WHERE id=?";

	public static ArrayList<CityDTO> getAllCitys() {
		ArrayList<CityDTO> citys = new ArrayList<>();
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT);
			// stmt.setObject(1, datum);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				citys.add(new CityDTO(rs.getInt(1), rs.getInt(4), rs.getString(2), rs.getDouble(3)));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		return citys;
	}

	public static boolean insertCity(CityDTO city) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, city.getName());
			stmt.setDouble(2, city.getPopulation());
			stmt.setInt(3, city.getID_Country());
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

	public static boolean deleteCity(int id) {
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

	public static boolean updateCity(CityDTO city, int id) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, city.getName());
			stmt.setDouble(2, city.getPopulation());
			stmt.setInt(3, city.getID_Country());
			stmt.setInt(4, id);
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
