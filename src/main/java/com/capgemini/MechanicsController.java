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
		//mechanics.date = java.time.LocalDateTime.now().format(formatter);
		mechanicsrepository.save(mechanics);
		
		return "Mechanic Details Added!!!";
	}
	
	@PutMapping("/{mechanicsId}")
	public String update(@PathVariable int mechanicsId,@RequestBody Mechanics mechanics ) {
		Mechanics dbMechanic=mechanicsrepository.findById(mechanicsId).get();
		if(dbMechanic!=null) {
			dbMechanic.setMechanicsName(mechanics.getMechanicsName());
			dbMechanic.setMechanicsAge(mechanics.getMechanicsAge());
			dbMechanic.setMechanicsMobile(mechanics.getMechanicsMobile());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			mechanics.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
			
		}
		mechanicsrepository.save(dbMechanic);
		return "Mechanic Updated!!!";
}
	@GetMapping("/{mechanicsId}")
	public Mechanics findById(@PathVariable int mechanicsId) {
		Mechanics dbMechanic=mechanicsrepository.findById(mechanicsId).get();
		System.out.println(dbMechanic);
		return(dbMechanic);
	}
	
	@GetMapping("/")
	public List<Mechanics> getRequest(){
		return mechanicsrepository.findAll();
	}
	
	/*@DeleteMapping("/{mechanicsId}")
	public String deleteUser(@PathVariable int mechanicsId) {
		Mechanics dbMechanic=mechanicsrepository.findById(mechanicsId).get();
		if(dbMechanic.isDeleted == false) {
			dbMechanic.isDeleted = true;
			mechanicsrepository.save(dbMechanic);
		}
		return "Mechanic Deleted";
	}*/

}
