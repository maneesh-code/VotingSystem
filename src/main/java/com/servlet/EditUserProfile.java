package com.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edit_user_profile")
public class EditUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();  
		request.getRequestDispatcher("editprofile.jsp").include(request, response);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/votersystem","root","admin@123"); 
			String newvotername = request.getParameter("newvotername");
			String newvoteraadhar = request.getParameter("newvoteraadhar");
			String newvoterphone = request.getParameter("newvoterphone");
			String newvoteradd = request.getParameter("newvoteradd");
			String email = (String)session.getAttribute("useremail");	
			
		//	PreparedStatement voterdata = con.prepareStatement("update users set name=?, adharid=?, phone=?, address=? where email=?");
		// 	PreparedStatement voterdata = con.prepareStatement("update users where email=? (name, adharid, phone, address) values(?,?,?,?)");
			PreparedStatement voterdata = con.prepareStatement("update users set name=?, adharid=?, phone=?, address=? where email=?");
			//update users set name="Maneesh sharma", adharid="821252726499", phone="8218973710", address="37 ka hanraj" where email="testing4@gmail.com";
			voterdata.setString(1, newvotername);
			voterdata.setString(2, newvoteraadhar);	
			voterdata.setString(3, newvoterphone);
			voterdata.setString(4, newvoteradd);
			voterdata.setString(5, email);
			
			voterdata.executeUpdate();

			con.close(); 
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		    response.sendRedirect("myaccount.jsp");
		

	}
	
    public EditUserProfile() {

    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
