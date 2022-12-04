package com.davidalejo.app.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	private Integer id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	private String direction;
	
	private String phone;
	
	private String type;
	
	private String password;
	

}
