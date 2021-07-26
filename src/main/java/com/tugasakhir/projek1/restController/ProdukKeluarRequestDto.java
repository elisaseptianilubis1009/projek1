package com.tugasakhir.projek1.restController;

import java.util.List;

public class ProdukKeluarRequestDto {
	
	private List<CartQuantityRequestDto> cartQuantityRequestDto;
	
	

	@Override
	public String toString() {
		return "ProdukKeluarRequestDto [cartQuantityRequestDto=" + cartQuantityRequestDto
				+ ", getCartQuantityRequestDto()=" + getCartQuantityRequestDto() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public List<CartQuantityRequestDto> getCartQuantityRequestDto() {
		return cartQuantityRequestDto;
	}

	public void setCartQuantityRequestDto(List<CartQuantityRequestDto> cartQuantityRequestDto) {
		this.cartQuantityRequestDto = cartQuantityRequestDto;
	}
	
	
	
}
