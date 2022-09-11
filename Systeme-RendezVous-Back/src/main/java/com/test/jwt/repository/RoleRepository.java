package com.test.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.jwt.model.ERole;
import com.test.jwt.model.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);

}
