package com.test.jwt.controller;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge=3600,allowCredentials="true")
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@GetMapping("/all")
	public String allAccess() {
		return "public content";
	}
	
	@GetMapping("/user")
//	@PreAuthorize("hashRole('USER') or hashRole('AGENT') or hashRole('ADMIN')")
	public String userAccess() {
		return "user content";
	}
	
	@GetMapping("/agent")
//	@PreAuthorize("hashRole('AGENT')")
	public String agentAccess() {
		return "agent dashboard";
	}
	
	@GetMapping("/admin")
//	@PreAuthorize("hashRole('ADMIN')")
	public String adminAccess() {
		return "admin dashboard";
	}
	
	

}
