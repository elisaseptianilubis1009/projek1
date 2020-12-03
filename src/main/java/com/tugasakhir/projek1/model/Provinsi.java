package com.tugasakhir.projek1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Provinsi {

	private Long kode;
	private String provinsi;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKode() {
		return kode;
	}
	public void setKode(Long id) {
		this.kode = id;
	}
	public String getProvinsi() {
		return provinsi;
	}
	public void setProvinsi(String nama_provinsi) {
		this.provinsi = nama_provinsi;
	}
	

}
