package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.credentials.UserCredentials;

@WebServlet("/login_user_id")
public class loginUserId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public loginUserId() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/votersystem","root","admin@123"); 
			String email = request.getParameter("voteremailaddress");
			String password = request.getParameter("voterpassword");
			
			PreparedStatement voterdata = con.prepareStatement("select * from users where email=?");
			voterdata.setString(1, email);
			//voterdata.setString(2, password);
			ResultSet rs = voterdata.executeQuery();
			
			if(rs.next()){
				String databasepassword = rs.getString("password");
				if(password.equals(databasepassword)) {
					System.out.println("Logged in User");
					response.sendRedirect("myaccount.jsp");
				}
				else {
					System.out.println("Wrong Credentials!");
					out.print("<h1>Wrong Credentials!</h1>");
				}
			}
			Cookie c = new Cookie("email",email);
			response.addCookie(c);
			
			con.close(); 	
			} catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}


		try {
			String name = request.getParameter("votername");
			String aadhar = request.getParameter("voteraadhar");
			String email = request.getParameter("voteremailaddress");
			String password = request.getParameter("voterpassword");
			
			UserCredentials usercredentials = new UserCredentials(0, name, aadhar, email, password);
			
			System.out.println(
			usercredentials.getEmail() + " : " + 
			usercredentials.getPassword());
			
			
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
	}

}
