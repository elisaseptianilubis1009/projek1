package com.tugasakhir.projek1.model;

import java.beans.Transient;

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
	private Integer quantity;
	private Integer total;
	private Integer subtotal;


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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotal() {
		this.total=0;
		this.total=this.quantity*this.produk.getHargaJual();
		
		return this.total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	@Transient
	public Integer getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
	
	
}
