package com.tugasakhir.projek1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugasakhir.projek1.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	List<Admin> findByAlamat(String alamat);



}
