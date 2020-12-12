package com.tugasakhir.projek1.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProdukMasuk {
	
	private Long kode;
	private Produk produk;
	private Date tglMasuk;
	private Integer jumlahProdukMasuk;
	private Date expayed;
	
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
	public void setProduk(Produk produkDetail) {
		this.produk = produkDetail;
	}
	public Date getTglMasuk() {
		return tglMasuk;
	}
	public void setTglMasuk(Date tglMasuk) {
		this.tglMasuk = tglMasuk;
	}
	public Integer getJumlahProdukMasuk() {
		return jumlahProdukMasuk;
	}
	public void setJumlahProdukMasuk(Integer jumlahProdukMasuk) {
		this.jumlahProdukMasuk = jumlahProdukMasuk;
	}
	public Date getExpayed() {
		return expayed;
	}
	public void setExpayed(Date expayed) {
		this.expayed = expayed;
	}
	
	
	

}
