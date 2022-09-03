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
			String email = request.getParameter("voterEmailAddress");
			String password = request.getParameter("voterPassword");
			
			UserCredentials usercredentials = new UserCredentials(email, password);
			
			System.out.println(
			usercredentials.getId() + " : " + 
			usercredentials.getEmail() + " : " + 
			usercredentials.getPassword());
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
	}

}
