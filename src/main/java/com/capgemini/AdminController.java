package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.ServiceCatalog;
import com.capgemini.entities.ServiceRequest;
import com.capgemini.entities.ServiceRequestDetail;
import com.capgemini.repository.ServiceCatalogRepository;
//import com.capgemini.repository.ServiceCatalogRepository;
import com.capgemini.repository.ServiceRequestDetailRepository;
import com.capgemini.repository.ServiceRequestRepository;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {

	@Autowired
	private ServiceRequestDetailRepository srdrepository;
	
	@Autowired
	private ServiceRequestRepository ser_reqrepository;
	
	/*@Autowired
	private ServiceCatalogRepository sercatrepository;*/
	
	@PostMapping("/generatedetail")
	public String generateRequestdetail(@RequestBody ServiceRequestDetail servicerequestdetail) {
		if(servicerequestdetail.getService_request()!=null) {
			ServiceRequest serreq=ser_reqrepository.findById(servicerequestdetail.getService_request().getService_req_id()).get();
			servicerequestdetail.setService_request(serreq);
		}
		/*if(servicerequestdetail.getServicecatalog()!=null) {
			ServiceCatalog sercat=sercatrepository.findById(servicerequestdetail.getServicecatalog().getService_catalog_id()).get();
			servicerequestdetail.setServicecatalog(sercat);
		}*/
		
		srdrepository.save(servicerequestdetail);
		return "Service Details generated!!!";
	}
	
}
