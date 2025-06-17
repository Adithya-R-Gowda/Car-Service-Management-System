package com.gqt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.AddCarDetails;


public class CustomerList extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AddCarDetails car = new AddCarDetails();
		ArrayList<AddCarDetails> carDetails =  car.customerList();
		session.setAttribute("carDetails", carDetails);
		
		
		if (carDetails != null) {
			response.sendRedirect("/Car-service-management-system/customerListSuccess.jsp");
		}
		else {
			response.sendRedirect("/Car-service-management-system/customerListFailure.jsp");
		}
	}
}
