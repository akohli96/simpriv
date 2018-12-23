package com.simpriv.api.port.primary.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCreateCommand {

	private String name;
	
	@JsonCreator
	public UserCreateCommand(@JsonProperty("username") String user) {
		this.name=user;
	}
	
	public String getName() {
		return this.name;
	}
}
