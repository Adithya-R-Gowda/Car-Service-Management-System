package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Customer;


public class CustomerRegister extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name = request.getParameter("name");
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confrimPassword");
			String email = request.getParameter("email");
			
			
			if (password.equals(confirmPassword)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("sname", name);
				Customer cust = new Customer(name, userName, password, email);
				int row = cust.customerRegister();
				if (row == 0) {
					response.sendRedirect("/Car-service-management-system/custRegUs.jsp");
				}
				else if (row == -1) {
					response.sendRedirect("/Car-service-management-system/reEnterUsername.jsp");
				}
				else {
					response.sendRedirect("/Car-service-management-system/custRegS.jsp");
				}
			}
			else {
				response.sendRedirect("/Car-service-management-system/passwordMismatch.jsp");
			}
			
	}

}
