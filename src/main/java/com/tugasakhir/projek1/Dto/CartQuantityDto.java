package com.tugasakhir.projek1.Dto;

import java.util.List;

public class CartQuantityDto {
	private List<String> cartId;
	private List<String> quantity;
	
	public List<String> getCartId() {
		return cartId;
	}
	public void setCartId(List<String> cartId) {
		this.cartId = cartId;
	}
	public List<String> getQuantity() {
		return quantity;
	}
	public void setQuantity(List<String> quantity) {
		this.quantity = quantity;
	}
	
	

}
