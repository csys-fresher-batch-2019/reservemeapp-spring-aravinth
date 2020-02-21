package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trainticket.createAccount.createAccountDAO;
import trainticket.createAccount.createAccountIMPL;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    			//response.getWriter().append("Served at: ").append(request.getContextPath());
    			createAccountDAO obj = new createAccountIMPL();
    			String userId1 = request.getParameter("userid");
    			int userId = Integer.parseInt(userId1);
    			boolean result=false;
    			PrintWriter out=response.getWriter();
    			String password = request.getParameter("userpassword");
    			try {
    				result=obj.checkLogin(userId, password);
    				out.println(result);
    				if(result==true) {
    					out.println("Login Successfull");
    	
    					HttpSession session = request.getSession();
						session.setAttribute("LOGGED_IN_USER_ID", userId);
    					
						RequestDispatcher dispatcher = request.getRequestDispatcher("choice.jsp");
    					dispatcher.forward(request, response);
    				}
    				else {
    					String res1 ="Invalid Userid/Password";
    					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp?res="+res1);
    					dispatcher.forward(request, response);
    				}
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
	
    }

	

}
