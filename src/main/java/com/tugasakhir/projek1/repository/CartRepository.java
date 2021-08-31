package com.tugasakhir.projek1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import com.tugasakhir.projek1.model.Cart;
import com.tugasakhir.projek1.model.Pembeli;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	List<Cart> findByPembeliAndStatus(Pembeli pembeli,Boolean status);
	
	List<Cart> findByKode(Long cardId);
	
//	List<Cart> findByPembeliAndStatus(ParamCartDto paramDto);
	
	@Modifying
    @Transactional
	@Query(nativeQuery = true,value = "SELECT  *  \r\n " + 
			" FROM cart WHERE  pembeli_id=:pembeli_id AND status=TRUE ")
	List<Object[]> getAllCart(
			@Param("pembeli_id") Long pembeli_id
			);
	

}
