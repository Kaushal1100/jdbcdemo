package com.example.demo.entity;


import com.example.demo.request.UserRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	public User(UserRequest userrequest) {
		this.id=userrequest.getId();
		this.name=userrequest.getName();
		this.email=userrequest.getEmail();
	}
	
	public User(int id,String name, String email) {
		this.id=id;
		this.name=name;
		this.email=email;
	}

}
