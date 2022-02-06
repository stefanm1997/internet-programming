package org.unibl.etf.ip.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONStringer;
import org.unibl.etf.ip.beans.FlightBean;
import org.unibl.etf.ip.dto.FlightDTO;
import org.unibl.etf.ip.dto.FlightScheduleDTO;
import org.unibl.etf.ip.dto.ScheduleDTO;

/**
 * Servlet implementation class Flight
 */
@WebServlet("/Flight")
public class Flight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Flight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FlightBean bean = new FlightBean();
		ArrayList<FlightDTO> flights = bean.getAllFlights();
		String action = request.getParameter("action");
		/*
		 * flights.stream().forEach(e -> {
		 * e.getFlightSchedules().getScheduleList().forEach(b ->
		 * System.out.println(b.getHour())); });
		 */
		//flights.subList(Math.max(flights.size()-5, 0), flights.size());
		if("allToday".equals(action)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String myDate = sdf.format(date);
			var allTodayFlights = new ArrayList<FlightDTO>();
			var allTodayHours = new ArrayList<String>();
			for (FlightDTO flightDTO : flights) {
				var schedules =flightDTO.getFlightSchedules();
				for (ScheduleDTO sche : schedules.getScheduleList()) {
					//System.out.println(sche);
					if(myDate.equals(sche.getDate())) {
						allTodayFlights.add(flightDTO);
						//Integer.parseInt(sche.getHour())
						allTodayHours.add(sche.getHour());
						
						//schedules.getScheduleList().remove(sche);
					}
				}
				//allTodayFlights.add(flightDTO);
			}
			System.out.println(allTodayFlights.size());
			allTodayHours.forEach(e -> {System.out.println(e);});
			Collections.sort(allTodayHours);
			allTodayHours.forEach(e -> {System.out.println(e);});
			var sortedTodayFlights = new ArrayList<FlightDTO>();
			for (String hours : allTodayHours) {
				for (FlightDTO flight : allTodayFlights) {
					var schedules =flight.getFlightSchedules();
					for (ScheduleDTO sche : schedules.getScheduleList()) {
						if(sche.getHour().equals(hours)&&sche.getDate().equals(myDate) && !sortedTodayFlights.contains(flight))
							sortedTodayFlights.add(flight);
					}
				}
			}
			System.out.println("Velicina sortirane"+sortedTodayFlights.size());
			sortedTodayFlights.forEach(e -> {System.out.println(e);});
			String jsonFlight = JSONStringer.valueToString(sortedTodayFlights);
			//System.out.println(jsonFlight);
			response.getWriter().println(jsonFlight);
			/*
			 * for (FlightDTO flightDTO : allTodayFlights) {
			 * schedules.add(flightDTO.getFlightSchedules().getScheduleList()); }
			 */
			//allTodayFlights.s
		}else if("all".equals(action)) {
			String jsonFlight = JSONStringer.valueToString(flights);
			//System.out.println(jsonFlight);
			response.getWriter().println(jsonFlight);
		}else if("allYesterday".equals(action)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis()-24*60*60*1000);
			String myDate = sdf.format(date);
			System.out.println(myDate);
			var allYesterdayFlights = new ArrayList<FlightDTO>();
			var allYesterdayHours = new ArrayList<String>();
			for (FlightDTO flightDTO : flights) {
				var schedules =flightDTO.getFlightSchedules();
				for (ScheduleDTO sche : schedules.getScheduleList()) {
					if(myDate.equals(sche.getDate())) {
						allYesterdayFlights.add(flightDTO);
						allYesterdayHours.add(sche.getHour());
					}
				}
			}
			Collections.sort(allYesterdayHours);
			var sortedYesterdayFlights = new ArrayList<FlightDTO>();
			for (String hours : allYesterdayHours) {
				for (FlightDTO flight : allYesterdayFlights) {
					var schedules =flight.getFlightSchedules();
					for (ScheduleDTO sche : schedules.getScheduleList()) {
						if(sche.getHour().equals(hours)&&sche.getDate().equals(myDate) && !sortedYesterdayFlights.contains(flight))
							sortedYesterdayFlights.add(flight);
					}
				}
			}
			String jsonFlight = JSONStringer.valueToString(sortedYesterdayFlights);
			response.getWriter().println(jsonFlight);
		}else if("allTomorrow".equals(action)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis()+24*60*60*1000);
			String myDate = sdf.format(date);
			System.out.println(myDate);
			var allTomorrowFlights = new ArrayList<FlightDTO>();
			var allTomorrowHours = new ArrayList<String>();
			for (FlightDTO flightDTO : flights) {
				var schedules =flightDTO.getFlightSchedules();
				for (ScheduleDTO sche : schedules.getScheduleList()) {
					if(myDate.equals(sche.getDate())) {
						allTomorrowFlights.add(flightDTO);
						allTomorrowHours.add(sche.getHour());
					}
				}
			}
			Collections.sort(allTomorrowHours);
			var sortedYesterdayFlights = new ArrayList<FlightDTO>();
			for (String hours : allTomorrowHours) {
				for (FlightDTO flight : allTomorrowFlights) {
					var schedules =flight.getFlightSchedules();
					for (ScheduleDTO sche : schedules.getScheduleList()) {
						if(sche.getHour().equals(hours)&&sche.getDate().equals(myDate) && !sortedYesterdayFlights.contains(flight))
							sortedYesterdayFlights.add(flight);
					}
				}
			}
			String jsonFlight = JSONStringer.valueToString(sortedYesterdayFlights);
			response.getWriter().println(jsonFlight);
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
