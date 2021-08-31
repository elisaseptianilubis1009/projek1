package com.tugasakhir.projek1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tugasakhir.projek1.model.TransaksiDetail;

public interface TransaksiDetailRepository extends JpaRepository<TransaksiDetail, Long> {
	
	List<TransaksiDetail> findByOrderId(String orderId);
	
	

}
