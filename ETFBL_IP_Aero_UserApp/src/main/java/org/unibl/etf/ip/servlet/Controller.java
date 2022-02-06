package org.unibl.etf.ip.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.unibl.etf.ip.beans.MessageBean;
import org.unibl.etf.ip.beans.ReservationBean;
import org.unibl.etf.ip.beans.UserBean;
import org.unibl.etf.ip.dto.MessageDTO;
import org.unibl.etf.ip.dto.ReservationDTO;
import org.unibl.etf.ip.dto.UserDTO;

/**
 * Servlet implementation class Controller
 */
@MultipartConfig
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String address = "/WEB-INF/pages/index.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		UserBean user = null;
		session.setAttribute("notificationReserve", "");
		if ((user = (UserBean) session.getAttribute("userBean")) == null) {
			user = new UserBean();
			session.setAttribute("userBean", user);
			session.setAttribute("notificationUser", "User is not logged!");
		}
		if (action == null || action.equals("")) {
			address = "/WEB-INF/pages/index.jsp";
		} else if (action.equals("logout")) {
			address = "/WEB-INF/pages/index.jsp";
			session.setAttribute("userBean", new UserBean());
		} else if (action.equals("login")) {
			System.out.println("Uso ovdje");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println(username);
			System.out.println(password);
			session.setAttribute("notification", "");
			// session.setAttribute("notificationUser", "User is not logged!");
			// session.setAttribute("notificationUser", "");
			// UserBean user = new UserBean();
			if (user.login(username, password)) {
				session.setAttribute("userBean", user);
				System.out.println("Korisnik je logovan!");
				address = "/WEB-INF/pages/index.jsp";
				session.setAttribute("notification", "");
				session.setAttribute("notificationUser", "");
				user.addAccessNumber();
				// response.sendRedirect(address);
			} else {
				if ("".equals(username) && !"".equals(password)) {
					session.setAttribute("notification", "Username is empty!");
				} else if ("".equals(password) && !"".equals(username)) {
					session.setAttribute("notification", "Password is empty!");
				} else if ("".equals(username) && "".equals(password)) {
					session.setAttribute("notification", "Username and password are empty!");
				} else
					session.setAttribute("notification", "Username or password are wrong!");
				session.setAttribute("notificationUser", "User is not logged!");
			}
		} else if (action.equals("register")) {
			address = "/WEB-INF/pages/register.jsp";
		} else if (action.equals("registration")) {
			address = "/WEB-INF/pages/register.jsp";
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			String userAddress = request.getParameter("address");
			String country = request.getParameter("country");
			String type = request.getParameter("type");
			UserDTO usr = new UserDTO(0, email, firstname, lastname, userAddress, country, username, password, type);
			System.out.println(usr);
			if ("".equals(firstname)) {
				session.setAttribute("notificationRegister", "Firstname is empty!");
			} else if ("".equals(lastname)) {
				session.setAttribute("notificationRegister", "Lastname is empty!");
			} else if ("".equals(email)) {
				session.setAttribute("notificationRegister", "Email is empty!");
			} else if ("".equals(username)) {
				session.setAttribute("notificationRegister", "Username is empty!");
			} else if ("".equals(password)) {
				session.setAttribute("notificationRegister", "Password is empty!");
			} else if ("".equals(password2)) {
				session.setAttribute("notificationRegister", "Repeat password is empty!");
			} else if ("".equals(userAddress)) {
				session.setAttribute("notificationRegister", "Address is empty!");
			} else if (!firstname.matches("^[a-zA-Z\\s]*$")) {
				session.setAttribute("notificationRegister", "For firstname only letters can be entered!");
			} else if (!lastname.matches("^[a-zA-Z\\s]*$")) {
				session.setAttribute("notificationRegister", "For lastname only letters can be entered!");
			} else if (!password.equals(password2)) {
				session.setAttribute("notificationRegister",
						"An error occurred, repeat password are not equal to first password!");
			} /*
				 * else if(!user.addUser(usr).equals("")) {
				 * session.setAttribute("notificationRegister",
				 * "An error occurred, the user is not registered !"); }
				 */else if (user.addUser(usr).equals("Duplicate email!")) {
				session.setAttribute("notificationRegister", "An error occurred, entered mail was taken!");
			} else {
				user.addUser(usr);
				session.setAttribute("notificationRegister", "Your registration was successful!");
			}
		} else if (action.equals("message")) {
			/*
			 * Consumer<String> cons = new Consumer<String>() {@Override public void
			 * accept(String t) { System.out.println(t);
			 * 
			 * } }; request.getParameterNames().asIterator().forEachRemaining(cons);
			 */
			String email = request.getParameter("inputEmail");
			String subject = request.getParameter("inputSubject");
			String message = request.getParameter("inputMessage");
			MessageDTO msg = new MessageDTO(0, subject, "Mail to: " + email + "\n  " + message, "New");
			if ("".equals(message)) {
				session.setAttribute("notificationMessage", "Content of message is empty!");
			} else if ("".equals(subject)) {
				session.setAttribute("notificationMessage", "Subject is empty!");
			} else if ("".equals(email)) {
				session.setAttribute("notificationMessage", "Email of recipient is empty!");
			} else {
				var resp = new MessageBean().addMessage(msg);
				if (!"Added".equals(resp)) {
					session.setAttribute("notificationMessage", "Error sending message!");
				} else {
					session.setAttribute("notificationMessage", "Message was successful sent!");
				}
			}
			address = "/WEB-INF/pages/index.jsp";
		} else if (action.equals("arrivals")) {
			address = "/WEB-INF/pages/arrivals.jsp";
		} else if (action.equals("departures")) {
			address = "/WEB-INF/pages/departures.jsp";
		} else if (action.equals("reservations")) {
			if (!user.isLoggedIn())
				address = "/WEB-INF/pages/index.jsp";
			else
				address = "/WEB-INF/pages/reservations.jsp";
		} else if (action.equals("reserve")) {
			if (!user.isLoggedIn())
				address = "/WEB-INF/pages/index.jsp";
			else
				address = "/WEB-INF/pages/reserve.jsp";
		} else if ("reservation".equals(action)) {
			address = "/WEB-INF/pages/reserve.jsp";
			ReservationBean reservationBean = new ReservationBean();
			var flightID = request.getParameter("flightID");
			var userID = user.getUser().getID();
			var date = request.getParameter("trip-start");
			var file = request.getParameter("fileURL");
			var fileUrl = request.getParameter("fileURL");
			// InputStream fileContent = filePart.getInputStream();
			// String rootDirectory = "C:\\Users\\Korisnik\\Desktop\\upload\\";
			// File uploads = new File(rootDirectory);
			session.setAttribute("notificationReserve", "");
			if (!"".equals(date)) {
				var reservation = new ReservationDTO(0, userID, Integer.parseInt(flightID), "New", date, "", null,
						null);
				if (reservationBean.addReservation(reservation)) {
					session.setAttribute("notificationReserve", "Reservation was created successfully!");
					if (!"".equals(fileUrl)) {
						Part filePart = request.getPart("myfile");
						// String fileName = filePart.getSubmittedFileName();
						String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
						File fi = new File(System.getProperty("user.dir") + "\\" + fileName);
						// File fi = new File("C:\\Upload\\" + fileName);
						// File fi = new File("C:\\Users\\Korisnik\\Desktop\\upload\\" + fileName);
						// for (Part part : request.getParts()) {
						// System.out.println("++++" + part);
						// part.write("C:\\Upload\\" + fileName);
						// }
						try (InputStream input = filePart.getInputStream()) {
							Files.copy(input, fi.toPath());
						}
					}
				} else {
					session.setAttribute("notificationReserve", "Something went wrong with reservation!");
				}
			} else
				session.setAttribute("notificationReserve", "Date of creation is not selected!");

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);

		// response.sendRedirect(address);
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
