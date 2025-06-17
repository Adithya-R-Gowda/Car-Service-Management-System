package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Customer;

public class CustomerLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Customer cust = new Customer();
		cust.setUserName(username);
		cust.setPassword(password);
		int login = cust.customerLogin();
		if (login == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("/Car-service-management-system/LoginSuccessful.jsp");
		}
		else if (login == 0) {
			response.sendRedirect("/Car-service-management-system/PasswordInvalid.jsp");
		}
		else {
			response.sendRedirect("/Car-service-management-system/UsernameInvalid.jsp");
		}
	}

}
