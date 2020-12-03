package com.tugasakhir.projek1.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Penjualan {

	private Long notaPenjualan;
	private Pembeli pembeli;
	private Integer totalPenjualan;
	private Date tglPenjualan;
	private Penerima penerima;
	private DetailCart detailCart;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getNotaPenjualan() {
		return notaPenjualan;
	}
	public void setNotaPenjualan(Long notaPenjualan) {
		this.notaPenjualan = notaPenjualan;
	}
	
	@ManyToOne
	public Pembeli getPembeli() {
		return pembeli;
	}
	public void setPembeli(Pembeli pembeli) {
		this.pembeli = pembeli;
	}
	public Integer getTotalPenjualan() {
		return totalPenjualan;
	}
	public void setTotalPenjualan(Integer totalPenjualan) {
		this.totalPenjualan = totalPenjualan;
	}
	public Date getTglPenjualan() {
		return tglPenjualan;
	}
	public void setTglPenjualan(Date tglPenjualan) {
		this.tglPenjualan = tglPenjualan;
	}
	
	@ManyToOne
	public Penerima getPenerima() {
		return penerima;
	}
	
	@ManyToOne
	public void setPenerima(Penerima penerima) {
		this.penerima = penerima;
	}
	
	@ManyToOne
	public DetailCart getDetailCart() {
		return detailCart;
	}
	public void setDetailCart(DetailCart detailCart) {
		this.detailCart = detailCart;
	}
	
	
	
}
