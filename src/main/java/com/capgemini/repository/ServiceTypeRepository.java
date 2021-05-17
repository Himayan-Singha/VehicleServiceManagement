package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType,Integer> {

}
