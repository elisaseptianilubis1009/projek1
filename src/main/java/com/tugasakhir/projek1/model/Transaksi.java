package com.tugasakhir.projek1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaksi")
public class Transaksi {
	private Long idTransaksi;
	private Long idPembeli;
	private String orderId;
	private String status;
	private String totalPesanan;
	private String namaLengkap;
	private String alamat;
	private String noTelepon;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getIdTransaksi() {
		return idTransaksi;
	}
	public void setIdTransaksi(Long idTransaksi) {
		this.idTransaksi = idTransaksi;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTotalPesanan() {
		return totalPesanan;
	}
	public void setTotalPesanan(String totalPesanan) {
		this.totalPesanan = totalPesanan;
	}
	public String getNamaLengkap() {
		return namaLengkap;
	}
	public void setNamaLengkap(String namaLengkap) {
		this.namaLengkap = namaLengkap;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getNoTelepon() {
		return noTelepon;
	}
	public void setNoTelepon(String noTelepon) {
		this.noTelepon = noTelepon;
	}
	public Long getIdPembeli() {
		return idPembeli;
	}
	public void setIdPembeli(Long idPembeli) {
		this.idPembeli = idPembeli;
	}
	
	
	

}
