package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.AddCarDetails;


public class RequestService extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			String carRegNum = request.getParameter("car_reg_num");
			String serviceType  = request.getParameter("service_type");
			
			AddCarDetails car = new AddCarDetails();
			car.setUsername(username);
			car.setCarRegNum(carRegNum);
			car.setServiceType(serviceType);
			
			int status = car.addServiceType();
			
			if(status == 0) {
				response.sendRedirect("ReqSerUnSuccessful.jsp");
			}
			else {
				response.sendRedirect("ReqSerSuccessful.jsp");
			}
	}

}
