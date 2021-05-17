package com.capgemini;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.VehicleType;
import com.capgemini.repository.VehicleTypeRepository;

@RestController
@RequestMapping("/api/vehicletype/")
public class VehicleTypeController {
	
	@Autowired
	private VehicleTypeRepository vehicletyperepository;
	
	@PostMapping("/")
	public String create(@RequestBody VehicleType vehicletype) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		vehicletype.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		vehicletype.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		vehicletype.date = java.time.LocalDateTime.now().format(formatter);
		
		vehicletyperepository.save(vehicletype);
		
		
		return "Vehicle Type Added";
	}

}
