package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.AddCarDetails;



public class CarDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String carModel = request.getParameter("carModel");
		String carType = request.getParameter("carType");
		String carRegNum = request.getParameter("carRegNum");
		
		AddCarDetails car = new AddCarDetails();
		car.setUsername(username);
		car.setCarModel(carModel);
		car.setCarType(carType);
		car.setCarRegNum(carRegNum);
		
		int status = car.addCarDetails();
		if (status == 0) {
			response.sendRedirect("/Car-service-management-system/DetailsFailed.jsp");
		}
		else {
			response.sendRedirect("/Car-service-management-system/DetailsAdded.jsp");
		}
	
	}
}
