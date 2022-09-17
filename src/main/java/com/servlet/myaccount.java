package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.credentials.UserCredentials;

@WebServlet("/myaccount")
public class myaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public myaccount() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PrintWriter out = response.getWriter();
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
			
			voterdata.execute()	;
			
			Cookie[] cookies = request.getCookies();
			boolean f = false;
			String username = "";
			if(cookies==null) {
				out.print("<h1>new User is sign in</h1>");
			}
			else {
				for(Cookie c:cookies) {
					String tname = null;
					if(tname.equals("user_name")) {
						f = true;
						name = c.getValue();
				}
				out.print("<h1></h1>");
			}
			
			con.close(); 
			} 
			if(f) {
				out.print(email);
			}
		}
		catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} 
		catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
