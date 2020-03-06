package com.chainsys.reservemeapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.reservemeapp.service.SeatStatusService;
@WebServlet("/AvailableSeatsServlet")
public class AvailableSeatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		//AdminListOfTrainsDAO dao = new AdminListOfTrainsImpl();
   		//AdminListOfTrainsService dao = new AdminListOfTrainsService();
   		//String Trainnum = request.getParameter("trainNum");
   		int trainnum = Integer.parseInt(request.getParameter("trainNum"));
   		System.out.println(111);
   		System.out.println(trainnum);
   		SeatStatusService dao = new SeatStatusService();
		try {
	   		int seatsCount = dao.AvailSeats(trainnum);
	   		request.setAttribute("seats", seatsCount);
	   		request.setAttribute("trainno", trainnum);
	   		RequestDispatcher rd = request.getRequestDispatcher("viewavailableseats.jsp");
	   		rd.forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}



}
