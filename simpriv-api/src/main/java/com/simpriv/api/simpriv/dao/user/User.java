package com.simpriv.api.simpriv.dao.user;

import java.util.UUID;

public class User {

	private String name;
	private String password;
	
	public User(String name) {
		this.name=name;
		this.password=UUID.randomUUID().toString();
	}
	
	public User(String name,String password) {
		this.name=name;
		this.password=password;
	}
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

}
