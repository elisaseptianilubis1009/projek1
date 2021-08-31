package com.tugasakhir.projek1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaksi_detail")
public class TransaksiDetail {
	
	private Long idDetail;
	private Produk produk;
	private Integer quantity;
	private String orderId;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getIdDetail() {
		return idDetail;
	}
	public void setIdDetail(Long idDetail) {
		this.idDetail = idDetail;
	}
	
	@ManyToOne
	public Produk getProduk() {
		return produk;
	}
	public void setProduk(Produk produk) {
		this.produk = produk;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
	
	
	

}
