package com.tugasakhir.projek1.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.model.ProdukKeluar;

@Repository
public interface ProdukKeluarRepository extends JpaRepository<ProdukKeluar, Long> {
	
	List<ProdukKeluar> findAllByProduk(Produk produk);

	List<ProdukKeluar> findByOrderId(String orderId);
	
	List<ProdukKeluar> findByStatus(Boolean status);
	
	Optional<ProdukKeluar> findByKode(Long Kode);
	
	@Modifying
    @Transactional
	@Query(nativeQuery = true,value = "SELECT p.nama_produk,p.kode,SUM(pk.quantity) AS Quantity,SUM(p.harga_jual) AS Total \r\n" + 
			"FROM produk p,produk_keluar pk WHERE p.kode=pk.produk_kode AND pk.status=TRUE AND pk.month=:month1 AND pk.year=:year1 \r\n" + 
			"GROUP BY pk.produk_kode;")
	List<Object[]> reportProduk(
			@Param("month1") Integer month1,
            @Param("year1") Integer year1
			);

}
