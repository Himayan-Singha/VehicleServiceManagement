package com.capgemini;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Enquiry;
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
		userdetailrepository.save(userdetails);
		return "User Details Added!!!";
	}
	
	@PutMapping("/{user_id}")
	public String update(@PathVariable int user_id,@RequestBody UserDetails userdetails) {
		UserDetails dbUser=userdetailrepository.findById(user_id).get();
		if(dbUser!=null) {
			dbUser.setUser_name(userdetails.getUser_name());
			dbUser.setUser_email(userdetails.getUser_email());
			dbUser.setUser_mobile(userdetails.getUser_mobile());
			dbUser.setUser_password(userdetails.getUser_password());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			userdetails.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		}
			userdetailrepository.save(dbUser);
			return "User Details Updated!!!";
		}
	@GetMapping("/{user_id}")
	public UserDetails findById(@PathVariable int user_id) {
		UserDetails dbUser=userdetailrepository.findById(user_id).get();
		System.out.println(dbUser);
		return(dbUser);
	}
	
	@GetMapping("/")
	public List<UserDetails> getRequest(){
		return userdetailrepository.findAll();
	}
	
	/*@DeleteMapping("/{user_id}")
	public String deleteUser(@PathVariable int user_id) {
		UserDetails dbUser=userdetailrepository.findById(user_id).get();
		if(dbUser.isDeleted == false) {
			dbUser.isDeleted = true;
			userdetailrepository.save(dbUser);
		}
		return "User Details Deleted";
	}*/

}
