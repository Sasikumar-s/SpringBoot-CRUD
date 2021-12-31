package com.kumaran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kumaran.model.User;
import com.kumaran.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;
	@GetMapping("/user")
	public List<User> getAllUser(){
		return service.listAll();
		
	}
	@PostMapping("/user")
	public User insertUser(@RequestBody User user) {
		return service.addUser(user);
	}
	@PutMapping("/user")
	public ResponseEntity<?> updateUser(@RequestBody User user,@RequestParam int id){
		try {
			User userdetails = service.get(id);
			userdetails.setName(user.getName());
			userdetails.setEmail(user.getEmail());
			service.addUser(userdetails);
			return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Exception Occured",HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/user")
	public void deleteUser(@RequestParam int id) {
		service.delete(id);
		
	}
//	@GetMapping("/find")
//	public User getOneUser(@RequestParam int id){
//			return service.get(id);
//		
//	}
	
	
}
