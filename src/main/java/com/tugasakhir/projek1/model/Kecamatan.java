package com.tugasakhir.projek1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Kecamatan {
	
	private Long kode;
	private String Kecamatan;
	private Kota kota;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKode() {
		return kode;
	}
	public void setKode(Long kode) {
		this.kode = kode;
	}
	public String getKecamatan() {
		return Kecamatan;
	}
	public void setKecamatan(String kecamatan) {
		Kecamatan = kecamatan;
	}
	
	@ManyToOne
	public Kota getKota() {
		return kota;
	}
	public void setKota(Kota kota) {
		this.kota = kota;
	}
	
	

}
