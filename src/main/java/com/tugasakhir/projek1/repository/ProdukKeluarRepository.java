package com.tugasakhir.projek1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.model.ProdukKeluar;

public interface ProdukKeluarRepository extends JpaRepository<ProdukKeluar, Long> {
	List<ProdukKeluar> findAllByProduk(Produk produk);
}
