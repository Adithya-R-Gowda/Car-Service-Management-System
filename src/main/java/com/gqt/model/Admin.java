package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Admin {
	private String userName;
	private String password;
	
	
	
	public Admin() {
		super();
	}


	public Admin(String username, String password) {
		super();
		this.userName = username;
		this.password = password;
	}


	public String getUsername() {
		return userName;
	}


	public void setUsername(String username) {
		this.userName = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int adminLogin() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_management", "root", "root");
			String s = "select * from admin where username = ?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, userName);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				if (res.getString(2).equals(password)) {
					return 1;
				}
				else {
					return 0;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	
	
	
	

}
