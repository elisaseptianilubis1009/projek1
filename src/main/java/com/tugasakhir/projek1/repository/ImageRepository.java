package com.tugasakhir.projek1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tugasakhir.projek1.model.Image;

@Repository
public interface ImageRepository  extends JpaRepository<Image, Long>{

}
