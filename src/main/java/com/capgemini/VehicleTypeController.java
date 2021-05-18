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
import com.capgemini.entities.Vehicle;
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
		//vehicletype.date = java.time.LocalDateTime.now().format(formatter);
		vehicletyperepository.save(vehicletype);
		return "Vehicle Type Added";
	}
	
	@PutMapping("/{vehicle_mod_id}")
	public String update(@PathVariable int vehicle_mod_id,@RequestBody VehicleType vehicletype ) {
		VehicleType dbVehicletype=vehicletyperepository.findById(vehicle_mod_id).get();
		if(dbVehicletype!=null) {
			
			dbVehicletype.setVehicle_model_name(vehicletype.getVehicle_model_name());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			vehicletype.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		}
			vehicletyperepository.save(dbVehicletype);
			return "Vehicle Updated!!!";
		}
	@GetMapping("/{vehicle_mod_id}")
	public VehicleType findById(@PathVariable int vehicle_mod_id ) {
		VehicleType dbVehicletype=vehicletyperepository.findById(vehicle_mod_id).get();
		System.out.println(dbVehicletype);
		return(dbVehicletype);
	}
	
	@GetMapping("/")
	public List<VehicleType> getRequest(){
		return vehicletyperepository.findAll();
	}
	/*@DeleteMapping("/{vehicle_mod_id}")
	public String deleteUser(@PathVariable int vehicle_mod_id) {
		VehicleType dbVehicletype=vehicletyperepository.findById(vehicle_mod_id).get();
		if(dbVehicletype.isDeleted == false) {
			dbVehicletype.isDeleted = true;
			vehicletyperepository.save(dbVehicletype);
		}
		return "VehicleType Deleted";
	}*/

}
