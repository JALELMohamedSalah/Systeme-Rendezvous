package com.test.jwt.payload.response;

import java.util.List;

public class JwtResponse {
	
private String token;

private String type="Bearer";

private long id;

private String username;

private String email;

private String password;

private List<String> roles;

public JwtResponse() {}
public JwtResponse(String accessToken,Long id, String username, String email, List<String> roles) {
	this.token= accessToken;
	this.id= id;
	this.username= username;
	this.email= email;
	this.roles= roles;
}

public String getToken() {
	return token;
}

public String getType() {
	return type;
}

public long getId() {
	return id;
}

public String getUsername() {
	return username;
}

public String getEmail() {
	return email;
}

public String getPassword() {
	return password;
}

public List<String> getRoles() {
	return roles;
}

public void setToken(String accessToken) {
	this.token = accessToken;
}

public void setType(String type) {
	this.type = type;
}

public void setId(long id) {
	this.id = id;
}

public void setUsername(String username) {
	this.username = username;
}

public void setEmail(String email) {
	this.email = email;
}

public void setPassword(String password) {
	this.password = password;
}

public void setRoles(List<String> roles) {
	this.roles = roles;
}





}
