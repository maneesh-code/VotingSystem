package com.servlet;

import java.io.IOException;
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
			
			String sql = " insert into users (name, aadhar, email, password)"
				    + " values (getName(), getAadhar(), getEmail(), getPassword(),)";
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
	}

}
