package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

public class AddCarDetails {
	private String username;
	private String carModel;
	private String carType;
	private String carRegNum;
	private String serviceType;
	private String serviceStatus;
	
	public AddCarDetails(String username, String carModel, String carType, String carRegNum, String serviceType,
			String serviceStatus) {
		super();
		this.username = username;
		this.carModel = carModel;
		this.carType = carType;
		this.carRegNum = carRegNum;
		this.serviceType = serviceType;
		this.serviceStatus = serviceStatus;
	}

	public AddCarDetails() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarRegNum() {
		return carRegNum;
	}

	public void setCarRegNum(String carRegNum) {
		this.carRegNum = carRegNum;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	
	
	
	@Override
	public String toString() {
		 return "<table border='1' cellpadding='5' cellspacing='0'>" +
		           "<tr><th>Field</th><th>Value</th></tr>" +
		           "<tr><td>Username</td><td>" + username + "</td></tr>" +
		           "<tr><td>Car Model</td><td>" + carModel + "</td></tr>" +
		           "<tr><td>Car Type</td><td>" + carType + "</td></tr>" +
		           "<tr><td>Car Reg Number</td><td>" + carRegNum + "</td></tr>" +
		           "<tr><td>Service Type</td><td>" + serviceType + "</td></tr>" +
		           "<tr><td>Service Status</td><td>" + serviceStatus + "</td></tr>" +
		           "<br> <br>" +
		           "</table>";
	}

	public int addCarDetails() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_management", "root", "root");
			String s = "insert into car value (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, username);
			pstmt.setString(2, carModel);
			pstmt.setString(3, carType);
			pstmt.setString(4, carRegNum);
			pstmt.setString(5, "false");
			pstmt.setString(6, "false");
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int addServiceType() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_management", "root", "root");
			String s = "update car set serviceType = ? where username = ? and carRegNum = ?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, serviceType);
			pstmt.setString(2, username);
			pstmt.setString(3, carRegNum);
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<AddCarDetails> serviceStatus() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_management", "root", "root");
			String s = "select * from car where username = ?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, username);
			ResultSet res = pstmt.executeQuery();
			ArrayList<AddCarDetails> carList = new ArrayList<AddCarDetails>(); 
			while (res.next()) {
				username = res.getString(1);
				carModel = res.getString(2);
				carType = res.getString(3);
				carRegNum = res.getString(4);
				serviceType = res.getString(5);
				serviceStatus = res.getString(6);
				AddCarDetails car = new AddCarDetails(username, carModel, carType, carRegNum, serviceType, serviceStatus);
				carList.add(car);
			}
			return carList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AddCarDetails> customerList() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_management", "root", "root");
			String s = "select * from car";
			PreparedStatement pstmt = con.prepareStatement(s);
			ResultSet res = pstmt.executeQuery();
			
			ArrayList<AddCarDetails> list = new ArrayList<AddCarDetails>();
			while (res.next()) {
				username = res.getString(1);
				carModel = res.getString(2);
				carType = res.getString(3);
				carRegNum = res.getString(4);
				serviceType = res.getString(5);
				serviceStatus = res.getString(6);
				AddCarDetails car = new AddCarDetails(username, carModel, carType, carRegNum, serviceType, serviceStatus);
				list.add(car);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public int updateServiceStatus() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_management", "root", "root");
			String s = "update car set serviceStatus = ? where carRegNum = ?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, "Serviced");
			pstmt.setString(2, carRegNum);
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
}
