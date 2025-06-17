package com.gqt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.AddCarDetails;


public class ServiceStatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		AddCarDetails car = new AddCarDetails();
		car.setUsername(username);
		
		ArrayList<AddCarDetails> carList = car.serviceStatus();
		session.setAttribute("carList", carList);
		
		if (carList == null) {
			response.sendRedirect("/Car-service-management-system/serviceStatusFailure.jsp");
		}
		else {
			response.sendRedirect("/Car-service-management-system/serviceStatusSuccess.jsp");
		}
		
	}
}
