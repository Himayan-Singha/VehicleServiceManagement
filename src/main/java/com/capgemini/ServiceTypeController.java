package com.capgemini;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.ServiceType;
import com.capgemini.repository.ServiceTypeRepository;

@RestController
@RequestMapping("/api/servicetype/")
public class ServiceTypeController {
	
	@Autowired
	private ServiceTypeRepository serviceTypeRepository;

	@PostMapping("/")
	public String createServiceType(@RequestBody ServiceType servicetype) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		servicetype.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		servicetype.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		servicetype.date = java.time.LocalDateTime.now().format(formatter);
		serviceTypeRepository.save(servicetype);
		return "Service Type Created!!!";
	}
}
