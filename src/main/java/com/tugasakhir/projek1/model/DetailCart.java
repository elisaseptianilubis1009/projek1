package com.tugasakhir.projek1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class DetailCart {
	
	public Long kodeDetail;
	public Cart cart;
	public Integer subtotal;
	public Integer diskon;
	public Integer biayaPengiriman;
	public Integer grandTotal;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKodeDetail() {
		return kodeDetail;
	}
	public void setKodeDetail(Long kodeDetail) {
		this.kodeDetail = kodeDetail;
	}
	
	@ManyToOne
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Integer getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}
	
	public Integer getDiskon() {
		return diskon;
	}
	public void setDiskon(Integer diskon) {
		this.diskon = diskon;
	}
	
	@Transient
	public Integer getBiayaPengiriman() {
		return biayaPengiriman;
	}
	public void setBiayaPengiriman(Integer biayaPengiriman) {
		this.biayaPengiriman = biayaPengiriman;
	}
	
	@Transient
	public Integer getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Integer grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	
	
	
	

}
