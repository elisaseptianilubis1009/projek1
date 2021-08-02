package com.tugasakhir.projek1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.model.ProdukKeluar;

public interface ProdukKeluarRepository extends JpaRepository<ProdukKeluar, Long> {
	
	List<ProdukKeluar> findAllByProduk(Produk produk);

	List<ProdukKeluar> findByOrderId(String orderId);
	
	Optional<ProdukKeluar> findByKode(Long Kode);

}
