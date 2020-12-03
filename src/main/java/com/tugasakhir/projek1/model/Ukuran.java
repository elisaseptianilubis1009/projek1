package com.tugasakhir.projek1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ukuran")
public class Ukuran {

	private Long kode;
	private String namaUkuran;
	private Integer berat;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKode() {
		return kode;
	}
	public void setKode(Long id) {
		this.kode = id;
	}
	public String getNamaUkuran() {
		return namaUkuran;
	}
	public void setNamaUkuran(String namaUkuran) {
		this.namaUkuran = namaUkuran;
	}
	public Integer getBerat() {
		return berat;
	}
	public void setBerat(Integer berat) {
		this.berat = berat;
	}
	
	
}
