package com.test.domain;


import java.io.Serializable;

public class User implements Serializable {
	private int u_id;
	private String u_name;
	private String password;
	
	public User() {
		super();
	}

	public User(int id, String username, String password) {
		super();
		this.u_id = id;
		this.u_name = username;
		this.password = password;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
