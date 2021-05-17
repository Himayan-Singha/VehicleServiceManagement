package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

}
