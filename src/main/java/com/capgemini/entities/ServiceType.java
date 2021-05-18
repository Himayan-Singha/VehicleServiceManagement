package com.capgemini.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "service_id", scope = Integer.class)
public class ServiceType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer service_id;
	private String service_desc;
	
	/*@Column(nullable = false)
	public boolean isDeleted = false;*/
	public String create_Date_Time;
	public String update_Date_Time;
	//public String date;
	
}
