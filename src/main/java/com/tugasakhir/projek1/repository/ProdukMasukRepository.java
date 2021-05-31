package com.tugasakhir.projek1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.model.ProdukMasuk;

public interface ProdukMasukRepository extends JpaRepository<ProdukMasuk, Long> {
	List<ProdukMasuk> findAllByProduk(Produk produk);
}
