package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.credentials.UserCredentials;

@WebServlet("/register_user_id")
public class RegisterUserId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterUserId() {

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PrintWriter out=response.getWriter();
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
			
//			if(voterdata.next())
//			{
//				RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
//				rd.forward(request, response);
//			}
//			else {
//				out.println("<h1>login fail</h1>");
//			}
			con.close(); 
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated cac
				e1.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

		
		
		try {
			String name = request.getParameter("votername");
			String aadhar = request.getParameter("voteraadhar");
			String email = request.getParameter("voteremailaddress");
			String password = request.getParameter("voterpassword");
			
			UserCredentials usercredentials = new UserCredentials(0, name, aadhar, email, password);
			
			System.out.println(
			usercredentials.getVoterid() + " : " + 
			usercredentials.getName() + " : " +
			usercredentials.getAadhar() + " : " +
			usercredentials.getEmail() + " : " + 
			usercredentials.getPassword());
			

			
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
	}

}
