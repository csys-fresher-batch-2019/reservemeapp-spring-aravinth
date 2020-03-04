package com.chainsys.reservemeapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.reservemeapp.dao.createAccountDAO;
import com.chainsys.reservemeapp.dao.impl.createAccountIMPL;
import com.chainsys.reservemeapp.model.createAccount;
import com.chainsys.reservemeapp.service.CreateAccountService;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//createAccountDAO dao = new createAccountIMPL();
		//Calling Method Using Service Layer
		CreateAccountService dao = new CreateAccountService();
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
