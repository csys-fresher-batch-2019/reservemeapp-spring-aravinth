package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trainticket.payment.paymentDAO;
import trainticket.payment.paymentDAOImpl;
@WebServlet("/updationServlet")
public class updationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		paymentDAO dao =  new paymentDAOImpl();
		PrintWriter out=response.getWriter();
		String Booking = request.getParameter("BookingId");
		int bookingId = Integer.parseInt(Booking);
		//out.println("bookingId");
		System.out.println(bookingId);
		String paymentMode = "cash";
		dao.cashPay(bookingId, paymentMode);
		response.sendRedirect("index.jsp");
		
	}

}
