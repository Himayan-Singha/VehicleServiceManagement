package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry,Integer> {

}
