package com.tugasakhir.projek1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Cart {

	private Long kode;
	private Produk produk;
	private Pembeli pembeli;
	private Integer kuantitas;
	private Integer total;
	
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
	
	@ManyToOne
	public Pembeli getPembeli() {
		return pembeli;
	}
	public void setPembeli(Pembeli pembeli) {
		this.pembeli = pembeli;
	}
	
	
	public Integer getKuantitas() {
		return kuantitas;
	}
	public void setKuantitas(Integer kuantitas) {
		this.kuantitas = kuantitas;
	}
	
	
	public Integer getTotal() {
		//this.total=getProduk().getHargaJual()*getKuantitas();	
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	
}
