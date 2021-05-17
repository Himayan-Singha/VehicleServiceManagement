package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {

}
