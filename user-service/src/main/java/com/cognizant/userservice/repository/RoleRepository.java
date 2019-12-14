package com.cognizant.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.userservice.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

	Role findByName(String user);
}
