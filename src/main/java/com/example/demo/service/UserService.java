package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Retrieve all users
    public List<User> getAllUsers() {
        return userRepository.userDetail();
    }

    // Add a new user (Transactional)
//    public User addUser(UserRequest userrequest) {
//    	int rowsAffected = userRepository.addUser(userrequest);
//        if (rowsAffected > 0) {
//            return "User added successfully";
//        } else {
//            throw new RuntimeException("Failed to add user");
//        }
    	
    	
    
    @Transactional
	public User addUser(UserRequest userRequest) {

		User user = new User(userRequest);

//    	user.setName(userRequest.getName());// DTO only till Service layer
//    	user.setEmail(userRequest.getEmail());

		return userRepository.addUser(user);

        
    }

    // Update a user (Transactional)
    @Transactional
	public User updateUser(int id, UserRequest userRequest) {
		User user = new User(userRequest);
		return userRepository.updateUser(user);

    }

    // Delete a user
    @Transactional
    public void deleteUser(int id) {
        int rowsAffected = userRepository.deleteUser(id);
        if (rowsAffected == 0) {
            throw new RuntimeException("Failed to delete user with ID " + id);
        }
    }

    // Paginated Users
    public List<User> getUsersWithPagination(int page, int pageSize) {
        return userRepository.getUsersWithPagination(page, pageSize);
    }
}
