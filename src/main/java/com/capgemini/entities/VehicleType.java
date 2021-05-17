package com.capgemini.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "vehicle_mod_id", scope = Integer.class)
public class VehicleType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer vehicle_mod_id;
	private String vehicle_model_name;
	
	public String create_Date_Time;
	public String update_Date_Time;
	public String date;
}
