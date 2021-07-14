package com.tugasakhir.projek1.restController;

public class OrderRequestDto {
	private TransactionDetailDto transaction_details;
	private CustomerDetailDto customer_details;

	public TransactionDetailDto getTransaction_details() {
		return transaction_details;
	}

	public void setTransaction_details(TransactionDetailDto transaction_details) {
		this.transaction_details = transaction_details;
	}

	public CustomerDetailDto getCustomer_details() {
		return customer_details;
	}

	public void setCustomer_details(CustomerDetailDto customer_details) {
		this.customer_details = customer_details;
	}

}
