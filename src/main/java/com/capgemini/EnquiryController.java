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
import com.capgemini.entities.ServiceRequest;
import com.capgemini.entities.UserDetails;
import com.capgemini.entities.VehicleType;
import com.capgemini.repository.EnquiryRepository;
import com.capgemini.repository.UserDetailsRepository;

@RestController
@RequestMapping("/api/enquiry")
public class EnquiryController {
	
	@Autowired
	private EnquiryRepository enquiryrepository;
	
	@Autowired
	private UserDetailsRepository userdetails_repo;
	
	@PostMapping("/")
	public String create(@RequestBody Enquiry enquiry) {
		if(enquiry.getUser_details()!=null) {
			UserDetails enq=userdetails_repo.findById(enquiry.getUser_details().getUser_id()).get();
			enquiry.setUser_details(enq);
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		enquiry.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		enquiry.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		//enquiry.date = java.time.LocalDateTime.now().format(formatter);
		enquiryrepository.save(enquiry);
		return "Enquiry Submitted!!!";
	}
	
	@PutMapping("/{enquiry_id}")
	public String update(@PathVariable int enquiry_id,@RequestBody Enquiry enquiry) {
		Enquiry dbEnquiry=enquiryrepository.findById(enquiry_id).get();
		if(dbEnquiry!=null) {
			dbEnquiry.setAdmin_response(enquiry.getAdmin_response());
			//dbEnquiry.setEnquiry_desc(enquiry.getEnquiry_desc());
			//dbEnquiry.setUser_details(enquiry.getUser_details());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			enquiry.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
			//enquiry.date = java.time.LocalDateTime.now().format(formatter);
			
		}
		enquiryrepository.save(dbEnquiry);
		return "Reponse Given!!!";
}
	@GetMapping("/{enquiry_id}")
	public Enquiry findById(@PathVariable int enquiry_id) {
		Enquiry dbEnquiry=enquiryrepository.findById(enquiry_id).get();
		System.out.println(dbEnquiry);
		return(dbEnquiry);
	}
	
	@GetMapping("/")
	public List<Enquiry> getRequest(){
		return enquiryrepository.findAll();
	}
	
	/*@DeleteMapping("/{enquiry_id}")
	public String deleteUser(@PathVariable int enquiry_id) {
		Enquiry dbEnquiry=enquiryrepository.findById(enquiry_id).get();
		if(dbEnquiry.isDeleted == false) {
			dbEnquiry.isDeleted = true;
			enquiryrepository.save(dbEnquiry);
		}
		return "VehicleType Deleted";
	}*/
}
