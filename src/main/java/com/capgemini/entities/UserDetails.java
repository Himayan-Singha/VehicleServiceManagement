package com.capgemini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "user_id", scope = Integer.class)
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int user_id;
	//@Column(nullable = false, unique = true)
	private String user_name;
	//@Column(nullable = false)
	private String user_email;
	//@Column(nullable = false)
	private String user_mobile;
	//@Column(nullable = false)
	private String user_password;
	//@Column(nullable = false)
	private String user_type;
	
	public String create_Date_Time;
	public String update_Date_Time;
	public String date;

}
