package com.tugasakhir.projek1.Dto;

public class saveTableTransaksiRequestDto {


	private String gross_amount;
	private String firs_name;
	private String last_name;
	private String email;
	private String telephone;
	private String alamat;
	
	public String getFirs_name() {
		return firs_name;
	}
	public void setFirs_name(String firs_name) {
		this.firs_name = firs_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getGross_amount() {
		return gross_amount;
	}
	public void setGross_amount(String gross_amount) {
		this.gross_amount = gross_amount;
	}
	
	
}
