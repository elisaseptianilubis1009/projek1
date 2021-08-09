package com.tugasakhir.projek1.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProdukKeluar {
	
	private Long kode;
	private Produk produk;
	private Integer quantity;
	private String orderId;
	private boolean status;
	private String statusConfirmation;
	private String color;
	private LocalDate tgl;
	
	private Integer month;
	private Integer year;

	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKode() {
		return kode;
	}
	public void setKode(Long kode) {
		this.kode = kode;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setProduk(Produk produk) {
		this.produk = produk;
	}
	@ManyToOne
	public Produk getProduk() {
		return produk;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getStatusConfirmation() {
		return statusConfirmation;
	}
	public void setStatusConfirmation(String statusConfirmation) {
		this.statusConfirmation = statusConfirmation;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public LocalDate getTgl() {
		return tgl;
	}
	public void setTgl(LocalDate tgl) {
		this.tgl = tgl;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	
	

	
}
