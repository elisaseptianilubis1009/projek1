package com.tugasakhir.projek1.Dto;

import java.util.List;

public class ListCardAndQuantityRequestDto {

	private List<CartRequestDto> CartRequestDto;
	private List<QuantityRequestDto> QuantityRequestDto;
	public List<CartRequestDto> getCartRequestDto() {
		return CartRequestDto;
	}
	public void setCartRequestDto(List<CartRequestDto> cartRequestDto) {
		CartRequestDto = cartRequestDto;
	}
	public List<QuantityRequestDto> getQuantityRequestDto() {
		return QuantityRequestDto;
	}
	public void setQuantityRequestDto(List<QuantityRequestDto> quantityRequestDto) {
		QuantityRequestDto = quantityRequestDto;
	}
	
	
}
