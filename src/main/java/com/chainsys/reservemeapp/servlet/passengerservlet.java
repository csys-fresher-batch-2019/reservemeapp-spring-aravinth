package com.chainsys.reservemeapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.reservemeapp.dao.passengerInfoDAO;
import com.chainsys.reservemeapp.dao.paymentDAO;
import com.chainsys.reservemeapp.dao.impl.passengerInfoIMPL;
import com.chainsys.reservemeapp.dao.impl.paymentDAOImpl;
import com.chainsys.reservemeapp.model.passengerInfo;
import com.chainsys.reservemeapp.service.PassengerInfoService;

@WebServlet("/passengerservlet")
public class passengerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// passengerInfoDAO dao = new passengerInfoIMPL();
		PassengerInfoService dao = new PassengerInfoService();
		passengerInfo p1 = new passengerInfo();
		paymentDAO dao1 = new paymentDAOImpl();
		PrintWriter out = response.getWriter();
		String TrainNum1 = request.getParameter("trainnum");
		p1.setTrainNum(Integer.parseInt(TrainNum1));
		String userId1 = request.getParameter("userid");
		p1.setUserId(Integer.parseInt(userId1));
		p1.setPassengerName(request.getParameter("passenger_name"));
		String PhoneNumber1 = request.getParameter("phone_number");
		p1.setPhoneNumber(Long.parseLong(PhoneNumber1));
		String NoOfTickets1 = request.getParameter("noOfTickets");
		p1.setNoOfTickets(Integer.parseInt(NoOfTickets1));
		try {
			int bookingId = dao.addPassenger(p1);
			// out.println("BOOKINGID :"+bookingId);
			int totAmount = dao1.totTicPrice(bookingId);
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_BOOKING_ID", bookingId);
			HttpSession session1 = request.getSession();
			session1.setAttribute("LOGGED_IN_TOT_AMOUNT", totAmount);

			RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentChoice.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
