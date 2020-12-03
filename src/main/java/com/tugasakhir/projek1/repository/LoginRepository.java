package com.tugasakhir.projek1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugasakhir.projek1.model.Login;

public interface LoginRepository extends JpaRepository<Login,Long> {
	
	Optional<Login> findByUsername(String username);
}
