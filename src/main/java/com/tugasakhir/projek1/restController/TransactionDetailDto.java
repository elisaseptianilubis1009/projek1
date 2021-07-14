package com.tugasakhir.projek1.restController;

public class TransactionDetailDto {
	private String order_id;
	private Integer gross_amount;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Integer getGross_amount() {
		return gross_amount;
	}

	public void setGross_amount(Integer gross_amount) {
		this.gross_amount = gross_amount;
	}

}
