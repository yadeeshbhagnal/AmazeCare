package com.hexaware.amazecare.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.amazecare.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
    Optional<Admin> findByUserName(String username);
}
