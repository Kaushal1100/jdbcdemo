package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/demo")
	public String check() {
		return "Welcome to my demo JDBC";
	}

	@GetMapping("/user")
	public List<User> getUserDetail() {
		return userRepository.userDetail();

	}

	// Adduser
	@PostMapping("/newuser")
	public String addUser(@RequestBody User user) {
		int rowsAffected = userRepository.addUser(user);
		return rowsAffected > 0 ? "User added successfully" : "Failed to add user";
	}

	//Updateuser
	@PutMapping("/{id}")
	public String updateUser(@PathVariable int id, @RequestBody User user) {
		user.setId(id);
		int rowsAffected = userRepository.updateUser(user);
		return rowsAffected > 0 ? "User updated successfully" : "Failed to update user";
	}

	// DeleteUser
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		int rowsAffected = userRepository.deleteUser(id);
		return rowsAffected > 0 ? "User deleted successfully" : "Failed to delete user";
	}
	
	 @GetMapping("/paginated") //http://localhost:8081/api/user/paginated?page=1&pageSize=5
	    public List<User> getUsersPagination(@RequestParam int page, @RequestParam int pageSize) {
	        return userRepository.getUsersWithPagination(page, pageSize);
	    }
}
