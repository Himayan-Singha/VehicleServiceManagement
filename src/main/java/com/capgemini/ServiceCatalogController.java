package com.capgemini;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Enquiry;
import com.capgemini.entities.ServiceCatalog;
import com.capgemini.entities.ServiceType;
import com.capgemini.repository.ServiceCatalogRepository;
import com.capgemini.repository.ServiceTypeRepository;

@RestController
@RequestMapping("/api/servicecatalog/")
public class ServiceCatalogController {
	
	@Autowired
	private ServiceCatalogRepository sercatrepository;
	@Autowired
	private ServiceTypeRepository sertyperepository;

	@PostMapping("/")
	public String create(@RequestBody ServiceCatalog servicecatalog) {
		
		if(servicecatalog.getServicetype()!=null) {
			ServiceType sertype=sertyperepository.findById(servicecatalog.getServicetype().getService_id()).get();
			servicecatalog.setServicetype(sertype);
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		servicecatalog.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		servicecatalog.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		servicecatalog.date = java.time.LocalDateTime.now().format(formatter);
		sercatrepository.save(servicecatalog);
		return "Service Catalog created!!!";
	}
	
	@GetMapping("/")
	public List<ServiceCatalog> getRequest(){
		return sercatrepository.findAll();
	}
}
