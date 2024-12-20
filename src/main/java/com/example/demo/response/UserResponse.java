package com.example.demo.response;

import com.example.demo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
	private int id;
	private String name;
	private String email;

	public UserResponse(User user) {
		this.id=user.getId();
		this.name=user.getName();
		this.email=user.getEmail();
	}
}

