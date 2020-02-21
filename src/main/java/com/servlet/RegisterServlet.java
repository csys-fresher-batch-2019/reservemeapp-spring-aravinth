package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trainticket.createAccount.createAccount;
import trainticket.createAccount.createAccountDAO;
import trainticket.createAccount.createAccountIMPL;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		createAccountDAO dao = new createAccountIMPL();
		createAccount l = new createAccount ();
		l.setUserName(request.getParameter("username"));
		l.setUserPassword(request.getParameter("userpassword"));
		l.setGender(request.getParameter("gender"));
		l.setDob(request.getParameter("birthday_date"));
		String contactnumber1 = request.getParameter("contact_number");
		l.setContactNumber(Long.parseLong(contactnumber1));
		l.setMailId(request.getParameter("email_id"));
		try {
			int userId = dao.AddUser(l);
			out.println("userId = "+userId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
