package com.tugasakhir.projek1.restController;

public class TransactionStatusResponseDto {

	
//	private String masked_card;
//	private String approval_code;
//	private String bank;
//	private String eci;
//	private String channel_response_code;
//	private String channel_response_message;
//	private String transaction_time;
//	private String gross_amount;
//	private String currency;
	private String transaction_status;
	private String order_id;
//	private String payment_type;
//	private String signature_key;
//	private String status_code;
//	private String transaction_id;
//	
//	private String fraud_status;
//	private String settlement_time;
//	private String status_message;
//	private String merchant_id;
//	private String card_type;
//	private String biller_code;
//	private String bill_key;
	

	
	public String getOrder_id() {
		return order_id;
	}

	
	public TransactionStatusResponseDto(String transaction_status, String order_id, String signature_key) {
	super();
	this.transaction_status = transaction_status;
	this.order_id = order_id;
}


	public TransactionStatusResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	

	public String getTransaction_status() {
		return transaction_status;
	}

	public void setTransaction_status(String transaction_status) {
		this.transaction_status = transaction_status;
	}


	

}
