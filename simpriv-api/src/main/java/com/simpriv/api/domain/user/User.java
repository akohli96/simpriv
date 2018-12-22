package com.simpriv.api.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.simpriv.api.port.primary.dto.UserCreateCommand;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public class User {

	private String name;
	private String password;
	private boolean enabled;
	private static final String ROLE = "ROLE_USER";
	private static final boolean ENABLED = true;
	private Collection<GrantedAuthority> grantedAuthorities;

	public User(String name) {
		this.name=name;
		this.password=UUID.randomUUID().toString();
		this.enabled=ENABLED;
		grantedAuthorities = Collections.singleton(new SimpleGrantedAuthority(ROLE));
	}

	public static User createUserFromCreateCommand(UserCreateCommand command){
		return new User(command.getName());
	}

	//For Database Only
	public User(String name,String password, String role, boolean enabled) {
		this.name=name;
		this.password=password;
		this.enabled=enabled;
		grantedAuthorities = Collections.singleton(new SimpleGrantedAuthority(role));
	}
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return grantedAuthorities.stream().findFirst().get().getAuthority();
	}

	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return grantedAuthorities;
	}

	@JsonIgnore
	public boolean isEnabled() {
		return enabled;
	}

	public UserCreateCommand convertToDTO(){
	    return new UserCreateCommand(this.name);
    }

}
