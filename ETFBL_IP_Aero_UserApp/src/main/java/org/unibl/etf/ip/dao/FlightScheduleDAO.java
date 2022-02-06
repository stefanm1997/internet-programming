package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.FlightDTO;
import org.unibl.etf.ip.dto.FlightScheduleDTO;
import org.unibl.etf.ip.dto.LocationDTO;
import org.unibl.etf.ip.dto.ScheduleDTO;

public class FlightScheduleDAO {

	private static final String SELECT = "SELECT * FROM flight_schedule WHERE FLIGHT_ID=?";
	
	public static FlightScheduleDTO getAllSchedulesByFlightId(int ID) {
		FlightScheduleDTO flightSchedule = new FlightScheduleDTO();
		ArrayList<ScheduleDTO> scheduleList = new ArrayList<ScheduleDTO>();
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnectionPool().checkOut();
			PreparedStatement stmt = conn.prepareStatement(SELECT);
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				//flights.add(new FlightDTO(rs.getInt(1), rs.getString(5), rs.getString(6), startLocation, endLocation));
				scheduleList.add(ScheduleDAO.getScheduleByID(rs.getInt(1)));
			}
			flightSchedule.setFlightID(ID);
			flightSchedule.setScheduleList(scheduleList);
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			ConnectionPool.getConnectionPool().checkIn(conn);
		}
		
		return flightSchedule;
	}
}
