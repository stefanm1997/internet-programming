package org.unibl.etf.ip.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.unibl.etf.ip.beans.FlightBean;
import org.unibl.etf.ip.beans.ReservationBean;
import org.unibl.etf.ip.beans.UserBean;
import org.unibl.etf.ip.dao.ReservationDAO;
import org.unibl.etf.ip.dto.FlightDTO;
import org.unibl.etf.ip.dto.ReservationDTO;

import com.mysql.cj.xdevapi.JsonParser;
import com.mysql.cj.xdevapi.JsonString;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String address = "/WEB-INF/pages/index.jsp";
		ReservationBean bean = new ReservationBean();
		ArrayList<ReservationDTO> reservations = bean.getAllReservations();
		String action = request.getParameter("action");;
		System.out.println("AKCIJA U RESERVATION"+action);
		HttpSession session = request.getSession();
		UserBean user = null;
		if ((UserBean) session.getAttribute("userBean") != null) {
			user = (UserBean) session.getAttribute("userBean");
		}
		/*
		 * if ((user = (UserBean) session.getAttribute("userBean")) == null) { user =
		 * new UserBean(); session.setAttribute("userBean", user); }
		 */
		session.setAttribute("notificationUser", "");
		if (!user.isLoggedIn()) {
			session.setAttribute("notificationUser", "User is not logged!");
		} else if ("allReservation".equals(action)) {
			System.out.println("Dobro gadja");
			ArrayList<ReservationDTO> userReservation = new ArrayList<ReservationDTO>();
			int userID = user.getUser().getID();
			System.out.println("ID:" + userID);
			for (ReservationDTO reservationDTO : reservations) {
				if (reservationDTO.getUSER_ID() == userID) {
					userReservation.add(reservationDTO);
				}
			}
			if (!userReservation.isEmpty()) {
				String jsonReservation = JSONStringer.valueToString(userReservation);
				System.out.println(jsonReservation);
				session.setAttribute("notificationUser", "");
				response.getWriter().println(jsonReservation);
			} else {
				System.out.println("Uradio ovo");
				session.setAttribute("notificationUser", "User has no reservations!");
			}
		} else if ("updateStatus".equals(action)) {
			System.out.println("Pogodio update");
			var status = request.getParameter("status");
			var id = request.getParameter("id");
			if (ReservationDAO.updateReservation(status, Integer.parseInt(id))) {
				System.out.println("Uspjesno");
			}

			// System.out.println(test);

		} else if ("reserve".equals(action)) {
			//System.out.println("Reserve!");
			FlightBean beanFlight = new FlightBean();
			ArrayList<FlightDTO> flights = beanFlight.getAllFlights();
			String jsonFlight = JSONStringer.valueToString(flights);
			response.getWriter().println(jsonFlight);
			//address = "/WEB-INF/pages/register.jsp";
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
