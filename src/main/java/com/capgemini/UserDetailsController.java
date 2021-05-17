package com.capgemini;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.UserDetails;
import com.capgemini.repository.UserDetailsRepository;

@RestController
@RequestMapping("/api/user/")
public class UserDetailsController {
	
	@Autowired
	private UserDetailsRepository userdetailrepository;
	
	@PostMapping("/")
	public String create(@RequestBody UserDetails userdetails) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		userdetails.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		userdetails.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		userdetails.date = java.time.LocalDateTime.now().format(formatter);
		userdetailrepository.save(userdetails);
		return "User Details Added!!!";
	}

}
