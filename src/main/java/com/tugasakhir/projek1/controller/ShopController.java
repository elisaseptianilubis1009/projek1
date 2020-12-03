package com.tugasakhir.projek1.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.repository.ImageRepository;
import com.tugasakhir.projek1.repository.ProdukRepository;

@Controller
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	ProdukRepository prd;
	
	@Autowired
	ImageRepository img;
	
	
	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String shop(Model model,Principal p) {	
		
	model.addAttribute("user",p);
	List<Produk> lproduk=prd.findAll();
	model.addAttribute("produk", lproduk);
	return "shop";
	
	}
	
	@RequestMapping (value="/detail/{id}", method = RequestMethod.GET)
	public String detail_shop(Model model, @PathVariable Long  id,Principal p) {
		model.addAttribute("user",p);
		Produk produk = prd.findById(id).get();
		model.addAttribute("produk",produk);

	return "shop-detail";
	
	}


}
