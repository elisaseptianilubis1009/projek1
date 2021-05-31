package com.tugasakhir.projek1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.tugasakhir.projek1.model.Cart;
import com.tugasakhir.projek1.model.Pembeli;
import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.model.Rasa;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	List<Cart> findByPembeli(Pembeli pembeli);
	

}
