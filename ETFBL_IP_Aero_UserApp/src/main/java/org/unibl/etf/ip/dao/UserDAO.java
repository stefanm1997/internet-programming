package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.AccessNumberDTO;
import org.unibl.etf.ip.dto.UserDTO;

public class UserDAO {
	
	private static final String SELECT = "SELECT * FROM user";
	private static final String INSERT = "INSERT INTO user (Email, Firstname, Lastname, Address, Country, Username, Password, Type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETE = "DELETE from user WHERE ID=?";
	private static final String UPDATE = "UPDATE user SET Email=?, Firstname=?, Lastname=?, Address=?, Country=?, Username=?, Password=?, Type=? WHERE ID=?";
	private static final String SELECT_MAIL = "SELECT * FROM user where Email=?";
	private static final String SELECT_ID = "SELECT * FROM user where ID=?";
	private static final String INSERT_ACCESS = "INSERT INTO access_number(Date, Number) VALUES(?,?)";
	private static final String UPDATE_ACCESS = "UPDATE access_number SET Number=? WHERE Date=?";
	private static final String SELECT_ACCESS_DATE = "SELECT * FROM access_number WHERE Date=?";

	public static ArrayList<UserDTO> getAllUsers() {
		ArrayList<UserDTO> users = new ArrayList<>();
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				users.add(new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		return users;
	}

	public static boolean insertUser(UserDTO user) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getFirstname());
			stmt.setString(3, user.getLastname());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getCountry());
			stmt.setString(6, user.getUsername());
			stmt.setString(7, user.getPassword());
			stmt.setString(8, user.getType());
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

	public static boolean deleteUser(int id) {
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

	public static boolean updateUser(UserDTO user, int id) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getFirstname());
			stmt.setString(3, user.getLastname());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getCountry());
			stmt.setString(6, user.getUsername());
			stmt.setString(7, user.getPassword());
			stmt.setString(8, user.getType());
			stmt.setInt(9, id);
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

	public static UserDTO getUserByEmail(String mail) {
		UserDTO user = null;
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT_MAIL);
			stmt.setString(1, mail);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		return user;
	}
	
	public static UserDTO getUserByID(int ID) {
		UserDTO user = null;
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ID);
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		return user;
	}
	
	public static AccessNumberDTO getAccessByDate(String date) {
		AccessNumberDTO access = null;
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ACCESS_DATE);
			stmt.setString(1, date);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				access = new AccessNumberDTO(rs.getInt(1), rs.getInt(3), rs.getString(2));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		return access;
	}
	
	public static boolean updateAccess(int number, String date) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(UPDATE_ACCESS);
			stmt.setInt(1, number);
			stmt.setString(2, date);
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
	
	public static boolean insertAccess(AccessNumberDTO access) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(INSERT_ACCESS);
			stmt.setString(1, access.getDate());
			stmt.setInt(2, access.getNumber());
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
