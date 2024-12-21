package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.example.demo.request.UserRequest;

@Repository
public class UserRepository {

	// Creates jdbctemplate object configured in the application.properties
	@Autowired
	JdbcTemplate jdbcTemplate;

//	//Get ALl usernames FOR Single Column
//	public List<String> getAllUserNames() {
//		List<String> userNameList = new ArrayList<>();
//		userNameList.addAll(jdbcTemplate.queryForList("select name from user ", String.class));
//		return userNameList;
//	} 

	// Get all userdetails
	public List<User> userDetail() {
		String sql = "SELECT * FROM user";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
	}

	// AddUser
	public User addUser(User user) {
		
		String sql = "INSERT INTO user (name, email) VALUES (?, ?)";
//		int rowsaffected= jdbcTemplate.update(sql, user.getName(), user.getEmail());
		
		// Use KeyHolder to retrieve the auto-generated ID
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Execute the insert query
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            return ps;
        }, keyHolder);

        // Retrieve the auto-generated key (assumes the key is numeric)
        int generateId=keyHolder.getKey().intValue();
		return new User(generateId,user.getName(),user.getEmail());	
		
	}
	

	// Update a user
	public User updateUser(User user) {
	    String sql = "UPDATE user SET name = ?, email = ? WHERE id = ?";

	    // Perform the update operation (no need for KeyHolder)
	    int rowsUpdated = jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getId());

	    if (rowsUpdated > 0) {
	        return user; // Successfully updated the user, return the updated user object
	    } else {
	        throw new RuntimeException("User not found with id: " + user.getId()); // Handle the failure if no rows are updated
	    }
	}

//	public int updateUser(UserRequest userrequest) 
//		public User updateUser(User user){
//		String sql = "UPDATE user SET name = ?, email = ? WHERE id = ?";
//		
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        // Execute the insert query
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, user.getName());
//            ps.setString(2, user.getEmail());
//            ps.setInt(3, user.getId()); 
//            
//            return ps;
//        }, keyHolder);
//
//        // Retrieve the auto-generated key (assumes the key is numeric)
//        int generateId=keyHolder.getKey().intValue();
//		return new User(generateId,user.getName(),user.getEmail());
////		return jdbcTemplate.update(sql, userrequest.getName(), userrequest.getEmail(), userrequest.getId());
//	}

	public int deleteUser(int id) {
		String sql = "DELETE FROM user WHERE id = ?";
		return jdbcTemplate.update(sql, id);
	}

	public List<User> getUsersWithPagination(int page, int size) {
		int offset = (page - 1) * size;
		String sql = "SELECT * FROM user LIMIT ? OFFSET ?";
		return jdbcTemplate.query(sql, new Object[] { size, offset }, (rs, rowNum) -> {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			return user;
		});
	}

}
