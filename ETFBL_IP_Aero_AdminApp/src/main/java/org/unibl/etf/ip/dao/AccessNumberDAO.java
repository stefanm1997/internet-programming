package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.AccessNumberDTO;

public class AccessNumberDAO {
	
	private static final String SELECT = "SELECT * FROM access_number";
	private static final String SELECT_LAST30 = "SELECT * FROM access_number WHERE access_number.Date BETWEEN CURDATE() - INTERVAL 30 DAY AND CURDATE();";
	
	public static ArrayList<AccessNumberDTO> getAllAccess() {
		ArrayList<AccessNumberDTO> access = new ArrayList<>();
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT_LAST30);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				access.add(new AccessNumberDTO(rs.getInt(1), rs.getInt(3), rs.getString(2)));
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

}
