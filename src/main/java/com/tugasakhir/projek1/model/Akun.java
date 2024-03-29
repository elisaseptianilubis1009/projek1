package com.tugasakhir.projek1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Akun {

	
	private Long kodeAkun;
	private String namaAkun;
	private String keteranganAkun;
	private Integer bulan;
	private Integer tahun;
	private Integer nominal;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKodeAkun() {
		return kodeAkun;
	}
	public void setKodeAkun(Long kodeAkun) {
		this.kodeAkun = kodeAkun;
	}
	public String getNamaAkun() {
		return namaAkun;
	}
	public void setNamaAkun(String namaAkun) {
		this.namaAkun = namaAkun;
	}
	public String getKeteranganAkun() {
		return keteranganAkun;
	}
	public void setKeteranganAkun(String keteranganAkun) {
		this.keteranganAkun = keteranganAkun;
	}
	
	public Integer getNominal() {
		return nominal;
	}
	public void setNominal(Integer nominal) {
		this.nominal = nominal;
	}
	public Integer getBulan() {
		return bulan;
	}
	public void setBulan(Integer bulan) {
		this.bulan = bulan;
	}
	public Integer getTahun() {
		return tahun;
	}
	public void setTahun(Integer tahun) {
		this.tahun = tahun;
	}
	
	
	
}
