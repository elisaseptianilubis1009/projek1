package com.tugasakhir.projek1.restController;

public class TotalRequestDto {
	
	private Long code;
	private Integer quantity;
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public TotalRequestDto(Long code, Integer quantity) {
		super();
		this.code = code;
		this.quantity = quantity;
	}
	
	
	
	

}
