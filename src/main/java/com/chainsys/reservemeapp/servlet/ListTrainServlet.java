package com.chainsys.reservemeapp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.reservemeapp.model.findTrain;
import com.chainsys.reservemeapp.service.FindTrainService;

@WebServlet("/ListTrainServlet")
public class ListTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// AdminListOfTrainsDAO dao = new AdminListOfTrainsImpl();
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String journeyDate = request.getParameter("journey_date");
		// findTrainDAO dao = new findTrainIMPL();
		FindTrainService dao = new FindTrainService();
		try {
			ArrayList<findTrain> list = dao.SearchTrain(source, destination, journeyDate);
			request.setAttribute("trainList", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listtrains.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
