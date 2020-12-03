package com.tugasakhir.projek1.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugasakhir.projek1.model.Login;
import com.tugasakhir.projek1.model.Pembeli;

public interface PembeliRepository extends JpaRepository<Pembeli,Long> {

	Optional<Pembeli> findByLogin(Login login);
	
}
