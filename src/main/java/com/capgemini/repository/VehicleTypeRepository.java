package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.VehicleType;

public interface VehicleTypeRepository extends JpaRepository<VehicleType,Integer> {

}
