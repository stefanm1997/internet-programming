package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.CountryDTO;

public class CountryDAO {

	private static final String SELECT = "SELECT * FROM country";
	private static final String INSERT = "INSERT INTO country (Name, ISO2, ISO3, Population) VALUES (?, ?, ?, ?)";
	private static final String DELETE = "DELETE from country WHERE id=?";
	private static final String UPDATE = "UPDATE country SET Name=?, ISO2=?, ISO3=?, Population=? WHERE id=?";

	public static ArrayList<CountryDTO> getAllCountrys() {
		ArrayList<CountryDTO> countrys = new ArrayList<>();
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT);
			// stmt.setObject(1, datum);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				countrys.add(new CountryDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5)));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		return countrys;
	}

	public static boolean insertCountry(CountryDTO country) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, country.getName());
			stmt.setString(2, country.getISO2());
			stmt.setString(3, country.getISO3());
			stmt.setDouble(4, country.getPopulation());
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

	public static boolean deleteCountry(int id) {
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

	public static boolean updateCountry(CountryDTO country, int id) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, country.getName());
			stmt.setString(2, country.getISO2());
			stmt.setString(3, country.getISO3());
			stmt.setDouble(4, country.getPopulation());
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
