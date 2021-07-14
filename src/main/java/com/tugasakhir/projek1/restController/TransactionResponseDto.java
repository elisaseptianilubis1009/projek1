package com.tugasakhir.projek1.restController;

public class TransactionResponseDto {

	private String token;
	private String redirect_url;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRedirect_url() {
		return redirect_url;
	}

	public void setRedirect_url(String redirect_url) {
		this.redirect_url = redirect_url;
	}

}
