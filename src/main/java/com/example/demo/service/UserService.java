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
    public String addUser(UserRequest userrequest) {
    	
        int rowsAffected = userRepository.addUser(userrequest);
        if (rowsAffected > 0) {
            return "User added successfully";
        } else {
            throw new RuntimeException("Failed to add user");
        }
    }

    // Update a user (Transactional)
    @Transactional
    public String updateUser(int id, UserRequest userrequest) {
    	userrequest.setId(id);
        int rowsAffected = userRepository.updateUser(userrequest);
        if (rowsAffected > 0) {
            return "User updated successfully";
        } else {
            throw new RuntimeException("Failed to update user");
        }
    }

    // Delete a user
    @Transactional
    public String deleteUser(int id) {
        int rowsAffected = userRepository.deleteUser(id);
        if (rowsAffected > 0) {
            return "User deleted successfully";
        } else {
            throw new RuntimeException("Failed to delete user");
        }
    }

    // Paginated Users
    public List<User> getUsersWithPagination(int page, int pageSize) {
        return userRepository.getUsersWithPagination(page, pageSize);
    }
}
