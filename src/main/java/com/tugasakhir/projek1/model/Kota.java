package com.tugasakhir.projek1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Kota {
	
	private Long kode;
	private String kota;
	private Provinsi provinsi;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKode() {
		return kode;
	}
	public void setKode(Long kode) {
		this.kode = kode;
	}
	public String getKota() {
		return kota;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}
	
	@ManyToOne
	public Provinsi getProvinsi() {
		return provinsi;
	}
	public void setProvinsi(Provinsi provinsi) {
		this.provinsi = provinsi;
	}
	
	

}
