package com.credentials;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserCredentials")
public class UserCredentials {
	
	@Id
	private int voterid;
	private String name;
	private String aadhar;
	private String email;
	private String password;
	public int getVoterid() {
		return voterid;
	}
	public void setVoterid(int voterid) {
		this.voterid = voterid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
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
	public UserCredentials(int voterid, String name, String aadhar, String email, String password) {
		super();
		this.voterid = new Random().nextInt(1000000); 
		this.name = name;
		this.aadhar = aadhar;
		this.email = email;
		this.password = password;
	}
	public UserCredentials() {
	}
	
	
}

