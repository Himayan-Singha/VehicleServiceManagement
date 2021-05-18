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
import com.capgemini.entities.ServiceType;
import com.capgemini.entities.VehicleType;
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
		//servicetype.date = java.time.LocalDateTime.now().format(formatter);
		serviceTypeRepository.save(servicetype);
		return "Service Type Created!!!";
	}
	
	@PutMapping("/{service_id}")
	public String update(@PathVariable int service_id,@RequestBody ServiceType servicetype ) {
		ServiceType dbServicetype=serviceTypeRepository.findById(service_id).get();
		if(dbServicetype!=null) {
			
			dbServicetype.setService_desc(servicetype.getService_desc());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			servicetype.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		}
		serviceTypeRepository.save(dbServicetype);
			return "Service Type Updated!!!";
		}
	@GetMapping("/{service_id}")
	public ServiceType findById(@PathVariable int service_id ) {
		ServiceType dbServicetype=serviceTypeRepository.findById(service_id).get();
		System.out.println(dbServicetype);
		return(dbServicetype);
	}
	
	@GetMapping("/")
	public List<ServiceType> getRequest(){
		return serviceTypeRepository.findAll();
	}
	
	/*@DeleteMapping("/{service_id}")
	public String deleteUser(@PathVariable int service_id) {
		ServiceType dbServicetype=serviceTypeRepository.findById(service_id).get();
		if(dbServicetype.isDeleted == false) {
			dbServicetype.isDeleted = true;
			serviceTypeRepository.save(dbServicetype);
		}
		return "VehicleType Deleted";
	}*/
	
}
