package com.simpriv.api.simpriv.dao.user.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

	private String name;
	
	@JsonCreator
	public UserDTO(@JsonProperty("username") String user) {
		this.name=user;
	}
	
	public String getName() {
		return this.name;
	}
}