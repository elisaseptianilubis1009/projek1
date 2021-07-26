package com.tugasakhir.projek1.restController;

public class CartQuantityRequestDto {
	
	private Long cartId;
	private Integer quantity;
	
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}


}
