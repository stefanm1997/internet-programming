package org.unibl.etf.ip.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.unibl.etf.ip.beans.ReservationBean;
import org.unibl.etf.ip.dto.ReservationDTO;

/**
 * Servlet implementation class Reserve
 */
@WebServlet("/Reserve")
public class Reserve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reserve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationBean bean = new ReservationBean();
		ArrayList<ReservationDTO> reservations = bean.getAllReservations();
		System.out.println("Udario ovaj GET");
		String address = "/WEB-INF/pages/index.jsp";
		String action = request.getParameter("action");
		if ("createReservation".equals(action)) {
			address = "/WEB-INF/pages/reserve.jsp";
			System.out.println("Dodaj rezervaciju");
			System.out.println(action);
			System.out.println(request.getParameter("seat"));
			System.out.println(request.getParameter("startLoc"));
			System.out.println(request.getParameter("endLoc"));
			var flgID =request.getParameter("flightIdentificator");
			System.out.println(flgID);
			System.out.println("UserID+" + request.getParameter("flightIdentificator"));
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
