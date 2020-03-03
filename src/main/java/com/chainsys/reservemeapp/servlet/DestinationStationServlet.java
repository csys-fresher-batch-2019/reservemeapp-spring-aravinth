package com.chainsys.reservemeapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.reservemeapp.adminrole.AdminListOfTrainsDAO;
import com.chainsys.reservemeapp.adminrole.AdminListOfTrainsImpl;
@WebServlet("/DestinationStationServlet")
public class DestinationStationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		AdminListOfTrainsDAO dao = new AdminListOfTrainsImpl();
		try {
			List<String> destinationStation = dao.getDestinationStation();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}



}
