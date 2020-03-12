package com.chainsys.reservemeapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.reservemeapp.dao.PaymentDAO;
import com.chainsys.reservemeapp.dao.impl.PaymentDAOImpl;
import com.chainsys.reservemeapp.service.PaymentService;

@WebServlet("/paymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Booking = request.getParameter("BookingId");
		int bookingId = Integer.parseInt(Booking);
		// long cardnum = Long.parseLong(request.getParameter("cardnumber"));
		// int cvv = Integer.parseInt(request.getParameter("cvv"));
		// String expiry = request.getParameter("expiry");
		// LocalDate exp = LocalDate.parse(expiry);
		// int totalAmount = Integer.parseInt(request.getParameter("totalAmounts"));
		// String comments = request.getParameter("purpose");
		try {
			// paymentDAO dao = new paymentDAOImpl();
			PaymentService dao = new PaymentService();
			String paySts = "paid";
			String paymentMode = "creditcard";
			dao.paymentMethod(bookingId,paySts,paymentMode);
			response.sendRedirect("index.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
