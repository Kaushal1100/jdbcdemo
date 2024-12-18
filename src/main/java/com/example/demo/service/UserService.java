package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.User;
import com.example.demo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Retrieve all users
    public List<User> getAllUsers() {
        return userRepository.userDetail();
    }

    // Add a new user (Transactional)
    @Transactional
    public String addUser(User user) {
        int rowsAffected = userRepository.addUser(user);
        if (rowsAffected > 0) {
            return "User added successfully";
        } else {
            throw new RuntimeException("Failed to add user");
        }
    }

    // Update a user (Transactional)
    @Transactional
    public String updateUser(int id, User user) {
        user.setId(id);
        int rowsAffected = userRepository.updateUser(user);
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
