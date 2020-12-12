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
import com.tugasakhir.projek1.model.Rasa;
import com.tugasakhir.projek1.repository.ProdukRepository;
import com.tugasakhir.projek1.repository.RasaRepository;

@Controller
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	ProdukRepository prd;
	
	@Autowired
	RasaRepository rr;
	
	
	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String shop(Model model,Principal p) {	
		
	model.addAttribute("user",p);
	List<Rasa> lrasa=rr.findAll();
	model.addAttribute("rasa", lrasa); 
	return "shop";
	
	}
	
	@RequestMapping (value="/pilih/{rasa}", method = RequestMethod.GET)
	public String shopPilih(Model model,Rasa rasa,Principal p) {
	model.addAttribute("user",p);
	List<Produk> listProduk=prd.findByRasa(rasa);
	model.addAttribute("listProduk",listProduk);
	model.addAttribute("rasa",rasa);
	return "shop-detail";
	
	}
	
	@RequestMapping (value="/detail/{rasa}", method = RequestMethod.GET)
	public String detail_shop(Model model,Rasa rasa ,@PathVariable Long  id,Principal p) {
		model.addAttribute("user",p);
		

	return "shop-detail";
	
	}


}
