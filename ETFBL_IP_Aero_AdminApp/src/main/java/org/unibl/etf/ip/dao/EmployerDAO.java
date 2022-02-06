package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.EmployerDTO;

public class EmployerDAO {
	
	private static final String SELECT = "SELECT * FROM employer";
	private static final String INSERT = "INSERT INTO employer (Username, Password, Firstname, Lastname) VALUES (?, ?, ?, ?)";
	private static final String DELETE = "DELETE from employer WHERE id=?";
	private static final String UPDATE = "UPDATE employer SET Username=?, Password=?, Firstname=?, Lastname=? WHERE id=?";

	public static ArrayList<EmployerDTO> getAllEmployers() {
		ArrayList<EmployerDTO> employers = new ArrayList<>();
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				employers.add(new EmployerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		return employers;
	}

	public static boolean insertEmployer(EmployerDTO employer) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, employer.getUsername());
			stmt.setString(2, employer.getPassword());
			stmt.setString(3, employer.getFirstname());
			stmt.setString(4, employer.getLastname());
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

	public static boolean deleteEmployer(int id) {
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

	public static boolean updateEmployer(EmployerDTO employer, int id) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, employer.getUsername());
			stmt.setString(2, employer.getPassword());
			stmt.setString(3, employer.getFirstname());
			stmt.setString(4, employer.getLastname());
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
