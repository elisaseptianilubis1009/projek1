package com.tugasakhir.projek1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="rasa")
public class Rasa {

	private Long kode;
	private String namaRasa;

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKode() {
		return kode;
	}
	public void setKode(Long id) {
		this.kode = id;
	
	}
	public String getNamaRasa() {
		return namaRasa;
	}
	public void setNamaRasa(String namaRasa) {
		this.namaRasa = namaRasa;
	}
		
}