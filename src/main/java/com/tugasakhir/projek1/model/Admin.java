package com.tugasakhir.projek1.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Admin {
	
	private Long id;
	private String alamat;
	private String noTelp;
	private String email;
	private String namaLengkap;
	private Login login;
	

//	public Admin(Long id, String alamat, String noTelp, String email, String namaLengkap, Login login) {
//		super();
//		this.id = id;
//		this.alamat = alamat;
//		this.noTelp = noTelp;
//		this.email = email;
//		this.namaLengkap = namaLengkap;
//		this.login = login;
//	}
	
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNamaLengkap() {
		return namaLengkap;
	}
	public void setNamaLengkap(String namaLengkap) {
		this.namaLengkap = namaLengkap;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getNoTelp() {
		return noTelp;
	}
	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	

}
