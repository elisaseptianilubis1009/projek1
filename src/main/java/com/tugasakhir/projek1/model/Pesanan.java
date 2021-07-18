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
	private Integer totalPesanan;
	private Date tglPesan;
	private String token;
	private boolean confirm;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKode() {
		return kode;
	}
	public void setKode(Long kode) {
		this.kode = kode;
	}
	
	public Date getTglPesan() {
		return tglPesan;
	}
	public void setTglPesan(Date tglPesan) {
		this.tglPesan = tglPesan;
	}
	
	public boolean isConfirm() {
		return confirm;
	}
	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
	public Integer getTotalPesanan() {
		return totalPesanan;
	}
	public void setTotalPesanan(Integer totalPesanan) {
		this.totalPesanan = totalPesanan;
	}
	
	
	
	

}
