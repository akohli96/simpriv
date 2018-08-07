package com.simpriv.api.simpriv.application.user;

import javax.ws.rs.HeaderParam;

public class UserFilterBean {

    private @HeaderParam("password") String password;
    private @HeaderParam("username") String username;

    public UserFilterBean(String username, String password){
        this.username=username;
        this.password=password;
    }

    public String getPassword(){
        return this.password;
    }

    public String getUsername(){
        return  this.username;
    }

}
