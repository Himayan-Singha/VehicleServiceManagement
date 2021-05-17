package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Mechanics;

public interface MechanicsRepository extends JpaRepository<Mechanics,Integer> {

}
