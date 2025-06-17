package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gqt.model.AddCarDetails;



public class UpdateServiceStatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carRegNum = request.getParameter("carRegNum");
		
		AddCarDetails car = new AddCarDetails();
		car.setCarRegNum(carRegNum);
		
		int status = car.updateServiceStatus();
		
		if (status == 0) {
			response.sendRedirect("/Car-service-management-system/UpdateUnsuccessfull.jsp");
		}
		else {
			response.sendRedirect("/Car-service-management-system/UpdateSuccessfull.jsp");
		}
	}

}
