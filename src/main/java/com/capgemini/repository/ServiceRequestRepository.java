package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest,Integer> {

}
