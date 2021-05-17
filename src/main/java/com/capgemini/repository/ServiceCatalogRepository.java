package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.ServiceCatalog;

public interface ServiceCatalogRepository extends JpaRepository<ServiceCatalog,Integer> {

}
