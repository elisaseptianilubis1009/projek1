package com.tugasakhir.projek1.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pesanan {
	private Long kode;
	private String firstName;
	private String lastName;
	private String email;
	private String noTelepon;
	private String alamat;
	private String totalPesanan;
	private String tglPesan;
	private String orderId;
	private String statusTransaction;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKode() {
		return kode;
	}
	public void setKode(Long kode) {
		this.kode = kode;
	}
	
	
	public String getTglPesan() {
		return tglPesan;
	}
	public void setTglPesan(String tglPesan) {
		this.tglPesan = tglPesan;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNoTelepon() {
		return noTelepon;
	}
	public void setNoTelepon(String noTelepon) {
		this.noTelepon = noTelepon;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getTotalPesanan() {
		return totalPesanan;
	}
	public void setTotalPesanan(String totalPesanan) {
		this.totalPesanan = totalPesanan;
	}
	public String getStatusTransaction() {
		return statusTransaction;
	}
	public void setStatusTransaction(String statusTransaction) {
		this.statusTransaction = statusTransaction;
	}
	
	
	
	
	

}
