package com.tugasakhir.projek1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tugasakhir.projek1.model.Admin;
import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.model.Rasa;

@Repository
public interface ProdukRepository extends JpaRepository<Produk, Long>{

	List<Produk> findByRasa(Rasa rasa);


}
