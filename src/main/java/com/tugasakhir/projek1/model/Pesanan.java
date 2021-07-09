package com.tugasakhir.projek1.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pesanan {
	private Long kode;
	private Pembeli namaPelanggan;
	private Produk namaProduk;
	private Integer jumlahPesanan;
	private Integer totalBayar;
	private Date tglPesan;
	private Date tglBayar;
	private boolean confirm;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKode() {
		return kode;
	}
	public void setKode(Long kode) {
		this.kode = kode;
	}
	@ManyToOne
	public Pembeli getNamaPelanggan() {
		return namaPelanggan;
	}
	
	public void setNamaPelanggan(Pembeli namaPelanggan) {
		this.namaPelanggan = namaPelanggan;
	}
	@ManyToOne
	public Produk getNamaProduk() {
		return namaProduk;
	}
	public void setNamaProduk(Produk namaProduk) {
		this.namaProduk = namaProduk;
	}
	public Integer getJumlahPesanan() {
		return jumlahPesanan;
	}
	public void setJumlahPesanan(Integer jumlahPesanan) {
		this.jumlahPesanan = jumlahPesanan;
	}
	public Integer getTotalBayar() {
		return totalBayar;
	}
	public void setTotalBayar(Integer totalBayar) {
		this.totalBayar = totalBayar;
	}
	public Date getTglPesan() {
		return tglPesan;
	}
	public void setTglPesan(Date tglPesan) {
		this.tglPesan = tglPesan;
	}
	public Date getTglBayar() {
		return tglBayar;
	}
	public void setTglBayar(Date tglBayar) {
		this.tglBayar = tglBayar;
	}
	public boolean isConfirm() {
		return confirm;
	}
	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}
	
	

}
