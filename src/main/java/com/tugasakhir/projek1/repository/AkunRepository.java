package com.tugasakhir.projek1.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tugasakhir.projek1.model.Akun;

@Repository
public interface AkunRepository extends JpaRepository<Akun, Long>{
	
	@Modifying
    @Transactional
	@Query(nativeQuery = true,value = "SELECT nama_akun,nominal \r\n " + 
			" FROM akun WHERE  bulan=:monthLabaRugi AND tahun=:yearLabaRugi ")
	List<Object[]> reportAkun(
			@Param("monthLabaRugi") Integer monthLabaRugi,
            @Param("yearLabaRugi") Integer yearLabaRugi
			);

}
