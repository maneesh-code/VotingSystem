package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register_user_id")
public class RegisterUserId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterUserId() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/votersystem","root","admin@123"); 
			String name = request.getParameter("votername");
			String aadhar = request.getParameter("voteraadhar");
			String email = request.getParameter("voteremailaddress");
			String password = request.getParameter("voterpassword");
			
			PreparedStatement voterdata = con.prepareStatement("insert into users (name, adharid, email, password)"
					+ " values(?, ?, ?, ?)");
			voterdata.setString(1, name);
			voterdata.setString(2, aadhar);	
			voterdata.setString(3, email);
			voterdata.setString(4, password);
			
			voterdata.execute();
			
			con.close(); 
			} catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		    response.sendRedirect("voterlogin.jsp");

	}
	
}
