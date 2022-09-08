package com.enities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Voter")
public class Voter {
	@Id
	private int id;
	private String votername;
	private String adharid;
	private String email;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVotername() {
		return votername;
	}
	public void setVotername(String votername) {
		this.votername = votername;
	}
	public String getContent() {
		return adharid;
	}
	public void setAdharid(String adharid) {
		this.adharid = adharid;
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
	
	public Voter(String votername, String adharid, Date addedDate, String email, String password) {
		super();
		this.id = new Random().nextInt(1000000); 
		this.votername = votername;
		this.adharid = adharid;
		this.email = email;
		this.password = password;
	}
	public Voter() {
		super();
	}

}
