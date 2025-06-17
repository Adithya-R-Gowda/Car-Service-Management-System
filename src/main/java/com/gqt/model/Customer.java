package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Customer {
		private String name;
		private String userName;
		private String password;
		private String email;
		
		
		
		public Customer() {
		}

		public Customer(String name, String userName, String password, String email) {
			super();
			this.name = name;
			this.userName = userName;
			this.password = password;
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		public int customerRegister() {
			try {
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_management", "root", "root");
				String s1 = "select * from customer where username = ?";
				PreparedStatement pstmt1 = con.prepareStatement(s1);
				pstmt1.setString(1, userName);
				ResultSet res = pstmt1.executeQuery();
				if (res.next()) {
					return -1;
				}
				else {
					String s = "insert into customer value (?, ?, ?, ?)";
					PreparedStatement pstmt = con.prepareStatement(s);
					pstmt.setString(1, name);
					pstmt.setString(2, userName);
					pstmt.setString(3, password);
					pstmt.setString(4, email); 
					int row = pstmt.executeUpdate();
					return row;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
			
		}
		
		public int customerLogin() {
			try {
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_management", "root", "root");
				String s = "select * from customer where username = ?";
				PreparedStatement pstmt = con.prepareStatement(s);
				pstmt.setString(1, userName);
				ResultSet res = pstmt.executeQuery();
				if (res.next()) {
					if (res.getString(3).equals(password)) {
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
