package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Admin;
import com.gqt.model.Customer;



public class AdminLogin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		Admin a = new Admin();
		a.setUsername(userName);
		a.setPassword(password);
		
		int status = a.adminLogin();
		
		if (status == 1) {
			response.sendRedirect("/Car-service-management-system/AdminLoginSuccessful.jsp");
		}
		else if (status == 0) {
			response.sendRedirect("/Car-service-management-system/AdminPasswordInvalid.jsp");
		}
		else {
			response.sendRedirect("/Car-service-management-system/AdminUsernameInvalid.jsp");
		}
		
	}
}


