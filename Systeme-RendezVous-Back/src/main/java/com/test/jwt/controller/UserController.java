package com.test.jwt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.jwt.repository.UserRepository;
import com.test.jwt.exception.ResourceNotFound;
import com.test.jwt.model.User;
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	private static final Error NotFound = null;
	@Autowired
	private  UserRepository userRepo;
	//get all users
	
		@GetMapping("/users")
		public List<User> getAllRendezVous(){
			return userRepo.findAll();
		}
		
		// add user
		@PostMapping("/users")
		public User createUser(@RequestBody User usr) {
			return userRepo.save(usr);//.passwordEncoder(passwordEncoder());;
		}
		@GetMapping("/users/{id}")
		public  ResponseEntity<User> getRendezVousById(@PathVariable Long id) {
			User rendezvous= userRepo.findById(id)
					.orElseThrow(()->new ResourceNotFound(NotFound));
					return ResponseEntity.ok(rendezvous);
					
				}
		
		
		@PutMapping("/users/{id}")
		public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User upUser){
			User rdv= userRepo.findById(id)
						.orElseThrow(()->new ResourceNotFound(NotFound));
			
			rdv.setUsername(upUser.getUsername());
			rdv.setEmail(upUser.getEmail());
			rdv.setPassword(upUser.getPassword());
			rdv.setRoles(upUser.getRoles());
		        
		        User updatedUsr=  userRepo.save(upUser);
		       
		       return ResponseEntity.ok(updatedUsr);
		}

		//delete employee
			@DeleteMapping("/users/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
				
				User usir= userRepo.findById(id)
						.orElseThrow(()->new ResourceNotFound(NotFound));
				
				userRepo.delete(usir);
				Map<String, Boolean> response=new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
				
			}
		
		
}



	
	
	
	
	
	
	
	
	
	

	


