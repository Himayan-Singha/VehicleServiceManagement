package com.capgemini;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.UserDetails;
import com.capgemini.entities.Vehicle;
import com.capgemini.entities.VehicleType;
import com.capgemini.repository.UserDetailsRepository;
import com.capgemini.repository.VehicleRepository;
import com.capgemini.repository.VehicleTypeRepository;

@RestController
@RequestMapping("/api/vehicle/")
public class VehicleController {
	
	@Autowired
	private VehicleRepository vehiclerepository;
	
	@Autowired
	private UserDetailsRepository userdetailsrepository;
	
	@Autowired
	private VehicleTypeRepository vehicletyperepository;

	@PostMapping("/")
	public String create(@RequestBody Vehicle vehicle) {
		
		if(vehicle.getUserdetails()!=null) {
			UserDetails user=userdetailsrepository.findById(vehicle.getUserdetails().getUser_id()).get();
			vehicle.setUserdetails(user);
		}
		if(vehicle.getVehicletype()!=null) {
			VehicleType vehi=vehicletyperepository.findById(vehicle.getVehicletype().getVehicle_mod_id()).get();
			vehicle.setVehicletype(vehi);
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		vehicle.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		vehicle.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		vehicle.date = java.time.LocalDateTime.now().format(formatter);
		vehiclerepository.save(vehicle);
		return "Vehicle Added!!!";
	}
}
