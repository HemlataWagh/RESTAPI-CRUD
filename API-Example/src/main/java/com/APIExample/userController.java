package com.APIExample;

import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/users")
public class userController {
	@Autowired
	private UserService service;
	public userController(UserService service)
	{
		super();
		this.service = service;
	}
	//build create user REST API
	@PostMapping()
	public ResponseEntity<userRegistration> saveuserRegistration(@RequestBody userRegistration user){
		return new ResponseEntity<userRegistration>(service.saveuserRegistration(user), HttpStatus.CREATED);
		
	}
	// Build get All User Rest API
	@GetMapping
	public List<userRegistration> getAllUsers()
	{
		return service.getAllusers();
		
	}
	// Build get user by id rest API
	@GetMapping("{userId}")
	public ResponseEntity<userRegistration> getUserRegistrationById(@PathVariable("userId") Integer userId){
		return new ResponseEntity<userRegistration>(service.getUserRegistrationById(userId), HttpStatus.OK);
	}
	// Build Update Rest Api 
	@PutMapping("{userId}")
	public ResponseEntity<userRegistration> updateRegistration(@PathVariable("userId") Integer userId,@RequestBody userRegistration user){
	return new ResponseEntity<userRegistration>(service.updateRegistration(user, userId),HttpStatus.OK);
		
	}
	// Build Delete Rest API
	@DeleteMapping("{userId}")
	public ResponseEntity<String> deleteuserRegistration(@PathVariable ("userId") Integer userId){
		service.deleteuserRegistration(userId);
		return new ResponseEntity<String>("User Registration Deleted successfully", HttpStatus.OK);
		
	}
	
	
}
