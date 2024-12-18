package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.User;

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

	//Get all userdetails
	public List<User> userDetail() {
		String sql = "SELECT * FROM user";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
	}
	//AddUser 
	public int addUser(User user) {
	    String sql = "INSERT INTO user (name, email) VALUES (?, ?)";
	    return jdbcTemplate.update(sql, user.getName(), user.getEmail());
	}

	//Update a user
    public int updateUser(User user) {
        String sql = "UPDATE user SET name = ?, email = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getId());
    }
    
    public int deleteUser(int id) {
        String sql = "DELETE FROM user WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
    
    public List<User> getUsersWithPagination(int page, int size) {
        int offset = (page - 1) * size;
        String sql = "SELECT * FROM user LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, new Object[]{size, offset}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        });
    }


}
