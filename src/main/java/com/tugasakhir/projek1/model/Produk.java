package com.tugasakhir.projek1.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Produk {

	private Long kode;
	private String namaProduk;
	private Rasa rasa;
	private Ukuran ukuran;
	private Integer hargaJual;
	private String gambar;
	private String Keterangan;
	private Integer stok;
	private List<ProdukMasuk> produkMasuk;
	private List<ProdukKeluar> produkKeluar;
	
	
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
	public String getKeterangan() {
		return Keterangan;
	}
	public void setKeterangan(String keterangan) {
		Keterangan = keterangan;
	}
	
	@Transient
	public Integer getStok() {
		this.stok=0;
		for(ProdukMasuk produkMasuk: this.produkMasuk) {
			this.stok+=produkMasuk.getJumlahProdukMasuk();	
		}
		
		for(ProdukKeluar produkKeluar : this.produkKeluar) {
			this.stok-=produkKeluar.getJumlahProdukKeluar();	
		}
		
		
		return this.stok;
		
		
	}
	
	
	public void setStok(Integer stok) {
		this.stok = stok;
	}
	@OneToMany(mappedBy = "produk")
	public List<ProdukMasuk> getProdukMasuk() {
		return produkMasuk;
	}
	public void setProdukMasuk(List<ProdukMasuk> produkMasuk) {
		this.produkMasuk = produkMasuk;
	}
	@OneToMany (mappedBy = "produk")
	public List<ProdukKeluar> getProdukKeluar() {
		return produkKeluar;
	}
	public void setProdukKeluar(List<ProdukKeluar> produkKeluar) {
		this.produkKeluar = produkKeluar;
	}

	

	
}
