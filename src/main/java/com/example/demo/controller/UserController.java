package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	
	UserService userService;

		@GetMapping(value="/userdetail",consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<UserResponse>> getUserDetail() {
		List<User> userList=userService.getAllUsers();
		List<UserResponse> userResponseList=new ArrayList<>();
		userList.stream().forEach(user -> {
			userResponseList.add(new UserResponse(user));
		});
		return ResponseEntity.ok(userResponseList);

	}

	// Adduser
	@PostMapping(value="/user",consumes = "application/json", produces = "application/json" )
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
		
		User user=userService.addUser(userRequest);
		UserResponse userResponse=new UserResponse(user);
		return ResponseEntity.ok(userResponse);
			
	}	
	
	// Updateuser
	@PutMapping(value="/user/{id}",consumes = "application/json", produces = "application/json" )
	public ResponseEntity<UserResponse> updateUser(@PathVariable int id, @RequestBody UserRequest userRequest) {
			
			User user = userService.updateUser(id, userRequest);
			UserResponse userResponse=new UserResponse(user);
			return ResponseEntity.status(HttpStatus.OK).body(userResponse);
		
	}
	
	@DeleteMapping(value="/user/{id}", produces = "application/json")
	public ResponseEntity<Map<String, String>> deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		Map<String, String> response = new HashMap<>();
		response.put("message", "User with ID " + id + " was deleted successfully.");

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


	// DeleteUser
//	@DeleteMapping(value="/user/{id}",consumes = "application/json")
//	public ResponseEntity<String> deleteUser(@PathVariable int id) {
//		try {
//			userService.deleteUser(id);
//			return ResponseEntity.status(HttpStatus.OK).body("User Deleted");
//		} catch (RuntimeException e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//		}
//	}

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
