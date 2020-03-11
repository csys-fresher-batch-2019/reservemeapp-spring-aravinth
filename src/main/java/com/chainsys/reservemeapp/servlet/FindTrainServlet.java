package com.chainsys.reservemeapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.reservemeapp.dao.TrainsDAO;
import com.chainsys.reservemeapp.dao.impl.TrainsDAOImpl;
import com.chainsys.reservemeapp.service.TrainsService;

@WebServlet("/FindTrainServlet")
public class FindTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// AdminListOfTrainsDAO dao = new AdminListOfTrainsImpl();
		TrainsService dao = new TrainsService();
		try {
			List<String> sourceStationList = dao.getSourceStation();
			List<String> destinationStation = dao.getDestinationStation();
			request.setAttribute("fromLocation", sourceStationList);
			request.setAttribute("toLocation", destinationStation);

			RequestDispatcher dispatcher = request.getRequestDispatcher("findtrain.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
