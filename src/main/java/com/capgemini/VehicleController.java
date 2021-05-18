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
		vehiclerepository.save(vehicle);
		return "Vehicle Added!!!";
	}
	
	@PutMapping("/{vehicle_reg_no}")
	public String update(@PathVariable int vehicle_reg_no,@RequestBody Vehicle vehicle ) {
		Vehicle dbVehicle=vehiclerepository.findById(vehicle_reg_no).get();
		if(dbVehicle!=null) {
			dbVehicle.setUserdetails(vehicle.getUserdetails());
			dbVehicle.setVehicle_color(vehicle.getVehicle_color());
			dbVehicle.setVehicle_desc(vehicle.getVehicle_desc());
			dbVehicle.setVehicle_man_yr(vehicle.getVehicle_desc());
			dbVehicle.setVehicletype(vehicle.getVehicletype());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			vehicle.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		}
			vehiclerepository.save(dbVehicle);
			return "Vehicle Updated!!!";
		}
	@GetMapping("/{vehicle_reg_no}")
	public Vehicle findById(@PathVariable int vehicle_reg_no ) {
		Vehicle dbVehicle=vehiclerepository.findById(vehicle_reg_no).get();
		System.out.println(dbVehicle);
		return(dbVehicle);
	}
	
	@GetMapping("/")
	public List<Vehicle> getRequest(){
		return vehiclerepository.findAll();
	}
	
	/*@DeleteMapping("/{vehicle_reg_no}")
	public String deleteUser(@PathVariable int vehicle_reg_no) {
		Vehicle dbVehicle=vehiclerepository.findById(vehicle_reg_no).get();
		if(dbVehicle.isDeleted == false) {
			dbVehicle.isDeleted = true;
			vehiclerepository.save(dbVehicle);
		}
		return "Vehicle Deleted";
	}*/
}
