package com.tugasakhir.projek1.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.model.ProdukMasuk;
import com.tugasakhir.projek1.model.Rasa;
import com.tugasakhir.projek1.repository.ProdukMasukRepository;
import com.tugasakhir.projek1.repository.ProdukRepository;

@Controller
@RequestMapping("/produkMasuk")
public class ProdukMasukController {
	
	@Autowired
	ProdukMasukRepository pmr;
	
	@Autowired
	ProdukRepository pr;
	
	@RequestMapping (value="/tampil",method = RequestMethod.GET)
	public String produk (Model model,Principal p) {
		model.addAttribute("user",p);
		List<ProdukMasuk> pMasuk=pmr.findAll();
		model.addAttribute("pMasuk",pMasuk);
		return "ProdukMasuk";	
	}
	
	
	//CRUD PRODUK MASUK___________________________________________________________________
		@RequestMapping (value="/create", method = RequestMethod.GET)
		public String tambahProdukMasuk(Model model,Principal p)  {
			
			ProdukMasuk produkMasuk=new ProdukMasuk();
			Produk produk=new Produk();
			produkMasuk.setProduk(produk);
			model.addAttribute("produkMasuk",produkMasuk);
			model.addAttribute("user",p);
			
			List<Produk> prod=pr.findAll();
			model.addAttribute("produk", prod);
			
			return "produkMasuk_Create";
		}
		
		@RequestMapping (value="/save", method = RequestMethod.POST)
		public String saveProdukMasuk(ProdukMasuk produkMasuk)
		{
			pmr.save(produkMasuk);
//			Produk produk=new Produk();
//			produk.setStok(produk.getStok()+produkMasuk.getJumlahProdukMasuk());
//			pr.save(produk);
			return "redirect:/produkMasuk/tampil";
		}
		
		@RequestMapping (value="/edit/{produkMasuk}", method = RequestMethod.GET)
		public String edit_pr(Model model, ProdukMasuk produkMasuk,Principal p){
			model.addAttribute("user",p);
			Produk produk=new Produk();
			produkMasuk.setProduk(produk);
			System.out.println("Kode Produk :"+produkMasuk.getProduk().getKode());
//			Optional<Produk> prod=pr.findById(produkMasuk.getProduk().getKode());
			List<Produk> prod=pr.findAll();
			
		
			model.addAttribute("produk", prod);
			return "produkMasuk_Create";
		}
		
		@RequestMapping (value="/delete/{id}", method = RequestMethod.GET)
		public String delete_mhs(@PathVariable Long id) {
			pmr.deleteById(id);
			return "redirect:/produkMasuk/tampil";
		}



}
