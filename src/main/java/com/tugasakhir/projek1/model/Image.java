package com.tugasakhir.projek1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Image {

	private Long kode;
	private Rasa rasa;
	private String image;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKode() {
		return kode;
	}
	public void setKode(Long kode) { 
		this.kode = kode;
	}
	
	@ManyToOne
	public Rasa getRasa() {
		return rasa;
	}
	public void setRasa(Rasa rasa) {
		this.rasa = rasa;
	}
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
