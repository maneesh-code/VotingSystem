package com.credentials;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserCredentials")
public class UserCredentials {
	
	@Id
	private int id;
	private String email;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserCredentials(String email, String password) {
		super();
		this.id = new Random().nextInt(1000000); 
		this.email = email;
		this.password = password;
	}
	public UserCredentials() {
		super();
	}

}
