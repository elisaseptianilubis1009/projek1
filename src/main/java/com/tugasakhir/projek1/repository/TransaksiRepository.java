package com.tugasakhir.projek1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugasakhir.projek1.model.Transaksi;
import com.tugasakhir.projek1.model.TransaksiDetail;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
	
	List<Transaksi> findByIdPembeli(Long idPembeli);
	
	Optional<Transaksi> findByOrderId(String orderId);

}
