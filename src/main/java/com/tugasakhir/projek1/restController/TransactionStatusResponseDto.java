package com.tugasakhir.projek1.restController;

public class TransactionStatusResponseDto {

	private String payment_type;
	private String bill_key;
	
	private String biller_code;
	private String transaction_time;
	
	private String gross_amount;
	private String currency;
	
	private String order_id;
	private String signature_key;
	
	private String status_code;
	private String transaction_id;
	
	private String transaction_status;
	private String fraud_status;
	
	private String status_message;
	
	private String merchant_id;

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getBill_key() {
		return bill_key;
	}

	public void setBill_key(String bill_key) {
		this.bill_key = bill_key;
	}

	public String getBiller_code() {
		return biller_code;
	}

	public void setBiller_code(String biller_code) {
		this.biller_code = biller_code;
	}

	public String getTransaction_time() {
		return transaction_time;
	}

	public void setTransaction_time(String transaction_time) {
		this.transaction_time = transaction_time;
	}

	public String getGross_amount() {
		return gross_amount;
	}

	public void setGross_amount(String gross_amount) {
		this.gross_amount = gross_amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getSignature_key() {
		return signature_key;
	}

	public void setSignature_key(String signature_key) {
		this.signature_key = signature_key;
	}

	public String getStatus_code() {
		return status_code;
	}

	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getTransaction_status() {
		return transaction_status;
	}

	public void setTransaction_status(String transaction_status) {
		this.transaction_status = transaction_status;
	}

	public String getFraud_status() {
		return fraud_status;
	}

	public void setFraud_status(String fraud_status) {
		this.fraud_status = fraud_status;
	}

	

	public String getStatus_message() {
		return status_message;
	}

	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}

	public String getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	
	
	

}
