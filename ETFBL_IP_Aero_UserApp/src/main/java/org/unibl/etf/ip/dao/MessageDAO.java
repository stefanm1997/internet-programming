package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.MessageDTO;


public class MessageDAO {

	private static final String SELECT = "SELECT * FROM message";
	private static final String INSERT = "INSERT INTO message (Subject, Content, Status) VALUES (?, ?, ?)";
	

	public static ArrayList<MessageDTO> getAllMessages() {
		ArrayList<MessageDTO> messages = new ArrayList<>();
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT);
			// stmt.setObject(1, datum);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// flights.add(new FlightDTO(rs.getInt(1), rs.getString(5), rs.getString(6),
				// startLocation, endLocation));
				messages.add(new MessageDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		return messages;
	}
	
	public static boolean insertMessage(MessageDTO message) {
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, message.getSubject());
			stmt.setString(2, message.getContent());
			stmt.setString(3, message.getStatus());
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
