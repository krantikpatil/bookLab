package com.booklab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
	private String name;
	private String email;
	private String phone;
	private String password;
	private String ROLE_USER;
	
	
	public Registration() {
		super();
	}


	public Registration(int id, String name, String email, String phone, String password, String rOLE_USER) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		ROLE_USER = rOLE_USER;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getROLE_USER() {
		return ROLE_USER;
	}


	public void setROLE_USER(String rOLE_USER) {
		ROLE_USER = rOLE_USER;
	}


	@Override
	public String toString() {
		return "Registration [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
				+ password + ", ROLE_USER=" + ROLE_USER + "]";
	}

	
}