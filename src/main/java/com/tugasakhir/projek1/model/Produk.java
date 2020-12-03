package com.tugasakhir.projek1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Produk {

	private Long kode;
	private String namaProduk;
	private Rasa rasa;
	private Ukuran ukuran;
	private Integer hargaJual;
	private Integer stok;
	private String gambar;
	private String Keterangan;
	
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getKode() {
		return kode;
	}
	public void setKode(Long kode) {
		this.kode = kode;
	}
	public String getNamaProduk() {
		return namaProduk;
	}
	public void setNamaProduk(String namaProduk) {
		this.namaProduk = namaProduk;
	}
	public Integer getHargaJual() {
		return hargaJual;
	}
	public void setHargaJual(Integer hargaJual) {
		this.hargaJual = hargaJual;
	}
		
	public String getKeterangan() {
		return Keterangan;
	}
	public void setKeterangan(String keterangan) {
		Keterangan = keterangan;
	}
	
	@Transient
	public Integer getStok() {
		//int stok = 0;
		
		return stok;
	}
	public void setStok(Integer stok) {
		this.stok = stok;
	}
	
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	public String getGambar() {
		return gambar;
	}
	public void setGambar(String gambar) {
		this.gambar = gambar;
	}
	
	@ManyToOne
	public Rasa getRasa() {
		return rasa;
	}
	public void setRasa(Rasa rasa) {
		this.rasa = rasa;
	}
	
	@ManyToOne
	public Ukuran getUkuran() {
		return ukuran;
	}
	public void setUkuran(Ukuran ukuran) {
		this.ukuran = ukuran;
	}



	
}
