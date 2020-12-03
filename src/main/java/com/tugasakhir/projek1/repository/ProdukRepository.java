package com.tugasakhir.projek1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tugasakhir.projek1.model.Produk;

@Repository
public interface ProdukRepository extends JpaRepository<Produk, Long>{


}
