package com.tomcat.learn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;


@WebServlet("/ProcessInfo")
public class ProcessInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProcessInfo() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
	IOException {	
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
	IOException {
		String url = "/DisplayInfo.jsp";
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String phone = request.getParameter("phone");
		
		updateDB(fName,lName,phone);
		Customer cust  = new Customer(fName,lName,phone);
		
		
		request.setAttribute("cust", cust);
		
		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);
	}
	
	
	
	
	protected void updateDB(String fName,String lName,
			String phone) {
		
		Connection conn;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://192.168.1.121:22080/tomcat";
			String user = "dbadmin";
			String passwd = "Allen62a!";
			conn = DriverManager.getConnection(url, user, passwd);
			Statement s = conn.createStatement();
			String query = "INSERT INTO customer" +
			"(first_name,last_name,phone,customer_id)" +
			"values('" + fName + "','" + lName + "','" +
			phone + "', null)";	
			
			s.executeUpdate(query);
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();	
		}
		catch(SQLException e) {
			e.printStackTrace();
	}

	}
}	
