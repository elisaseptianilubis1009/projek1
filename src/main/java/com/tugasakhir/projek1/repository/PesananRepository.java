package com.tugasakhir.projek1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugasakhir.projek1.model.Pesanan;
import com.tugasakhir.projek1.model.ProdukKeluar;

public interface PesananRepository extends JpaRepository<Pesanan, Long> {
	
	Optional<Pesanan> findByOrderId(String orderId);

}
