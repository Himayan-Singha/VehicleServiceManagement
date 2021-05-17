package com.capgemini;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Mechanics;
import com.capgemini.repository.MechanicsRepository;

@RestController
@RequestMapping("/api/mechanics/")
public class MechanicsController {
	
	@Autowired
	private MechanicsRepository mechanicsrepository;
	
	@PostMapping("/")
	public String create(@RequestBody Mechanics mechanics) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		mechanics.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		mechanics.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		mechanics.date = java.time.LocalDateTime.now().format(formatter);
		mechanicsrepository.save(mechanics);
		
		return "Mechanic Details Added!!!";
	}

}
