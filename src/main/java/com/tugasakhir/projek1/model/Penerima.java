package com.tugasakhir.projek1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Penerima {
	
	private Long idPenerima;
	private Pembeli pembeli;
	private String namaPenerima;
	private String noTelp;
	private Kecamatan kecamatan;
	private String alamatLengkap;
	private Integer kodePos;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getIdPenerima() {
		return idPenerima;
	}
	public void setIdPenerima(Long idPenerima) {
		this.idPenerima = idPenerima;
	}
	
	@ManyToOne
	public Pembeli getPembeli() {
		return pembeli;
	}
	public void setPembeli(Pembeli pembeli) {
		this.pembeli = pembeli;
	}
	public String getNamaPenerima() {
		return namaPenerima;
	}
	public void setNamaPenerima(String namaPenerima) {
		this.namaPenerima = namaPenerima;
	}
	public String getNoTelp() {
		return noTelp;
	}
	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}
	
	@ManyToOne
	public Kecamatan getKecamatan() {
		return kecamatan;
	}
	public void setKecamatan(Kecamatan kecamatan) {
		this.kecamatan = kecamatan;
	}
	public String getAlamatLengkap() {
		return alamatLengkap;
	}
	public void setAlamatLengkap(String alamatLengkap) {
		this.alamatLengkap = alamatLengkap;
	}
	public Integer getKodePos() {
		return kodePos;
	}
	public void setKodePos(Integer kodePos) {
		this.kodePos = kodePos;
	}
	
	
	

}
