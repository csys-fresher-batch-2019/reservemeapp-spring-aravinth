package com.chainsys.reservemeapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.reservemeapp.dao.CreateAccountDAO;
import com.chainsys.reservemeapp.dao.impl.CreateAccountImpl;
import com.chainsys.reservemeapp.service.CreateAccountService;

@WebServlet("/forgetPasswordServle")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// createAccountDAO dao =new createAccountIMPL();
		CreateAccountService dao = new CreateAccountService();
		String userid = request.getParameter("userid");
		int userId = Integer.parseInt(userid);
		String mailId = request.getParameter("mailid");
		boolean result = false;
		try {
			result = dao.checkId(userId, mailId);
			if (result == true) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("resetpassword.jsp");
				dispatcher.forward(request, response);
			}
			if (result == false) {
				String result1 = "Invalid UserId / emailId";
				response.sendRedirect("forgetpassword.jsp?res=" + result1);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
