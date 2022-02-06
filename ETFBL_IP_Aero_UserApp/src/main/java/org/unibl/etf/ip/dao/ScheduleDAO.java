package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.ScheduleDTO;

public class ScheduleDAO {

	private static final String SELECT = "SELECT * FROM schedule";
	private static final String SELECT_BY_ID = "SELECT * FROM schedule where ID=?";

	public static ArrayList<ScheduleDTO> getAllSchedules() {
		ArrayList<ScheduleDTO> schedules = new ArrayList<>();
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT);
			// stmt.setObject(1, datum);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// flights.add(new FlightDTO(rs.getInt(1), rs.getString(5), rs.getString(6),
				// startLocation, endLocation));
				schedules.add(new ScheduleDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		return schedules;
	}

	public static ScheduleDTO getScheduleByID(int ID) {
		ScheduleDTO schedule = null;
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				schedule = new ScheduleDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			} else {
				System.out.println("Nema elementa!");
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		return schedule;
	}
}
