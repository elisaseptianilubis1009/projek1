package com.tugasakhir.projek1.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProdukKeluar {
	
	private Long kode;
	private Produk produk;
	private Date tglKeluar;
	private Integer jumlahProdukKeluar;

	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKode() {
		return kode;
	}
	public void setKode(Long kode) {
		this.kode = kode;
	}
	
	@ManyToOne
	public Produk getProduk() {
		return produk;
	}
	public void setProduk(Produk produk) {
		this.produk = produk;
	}
	public Date getTglKeluar() {
		return tglKeluar;
	}
	public void setTglKeluar(Date tglKeluar) {
		this.tglKeluar = tglKeluar;
	}
	public Integer getJumlahProdukKeluar() {
		return jumlahProdukKeluar;
	}
	public void setJumlahProdukKeluar(Integer jumlahProdukKeluar) {
		this.jumlahProdukKeluar = jumlahProdukKeluar;
	}
	
}
