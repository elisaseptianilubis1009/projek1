package com.tugasakhir.projek1.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tugasakhir.projek1.repository.ProdukKeluarRepository;

@Controller
@RequestMapping("/produkKeluar")
public class ProdukKeluarController {

	@Autowired
	private ProdukKeluarRepository produkKeluarRepository;
	
	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String Produk_Keluar(Model model,Principal p) {
		model.addAttribute("user",p);

		
		return "ProdukKeluar";
	}

}
