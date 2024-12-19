package com.example.demo.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	
	UserService userService;

	@GetMapping("/demo")
	public String check() {
		return "Welcome to my demo JDBC";
	}

	@GetMapping("/userdetail")
	public List<User> getUserDetail() {
		return userService.getAllUsers();

	}

	// Adduser
	@PostMapping("/user")
	public ResponseEntity<String> createUser(@RequestBody UserRequest userrequest) {

		try {
			userService.addUser(userrequest);
			return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}	
	
	// Updateuser
	@PutMapping("/user/{id}")
	public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody UserRequest userrequest) {
		try {
			String result = userService.updateUser(id, userrequest);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	// DeleteUser
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		try {
			userService.deleteUser(id);
			return ResponseEntity.status(HttpStatus.OK).body("User Deleted");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/userlist") // http://localhost:8081/api/user/paginated?page=1&pageSize=5
	public ResponseEntity<List<User>> getUsersPagination(@RequestParam int page, @RequestParam int pageSize) {
		List<User> users = userService.getUsersWithPagination(page, pageSize);
		if (users.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(users);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(users);
		}
	}
}
