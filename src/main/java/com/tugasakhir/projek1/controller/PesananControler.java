package com.tugasakhir.projek1.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tugasakhir.projek1.model.Pesanan;
import com.tugasakhir.projek1.repository.PesananRepository;

@Controller
@RequestMapping("/pesanan")
public class PesananControler {
	
	@Autowired
	private PesananRepository pesananRepository;
	
	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String rasaProduk(Model model,Principal p) {
		model.addAttribute("user",p);

		List<Pesanan> lpesanan=pesananRepository.findAll();
		model.addAttribute ("pesanan", lpesanan);
		return "pesanan";
	}
	
	@RequestMapping (value="/modal", method = RequestMethod.GET)
	public String modal(Model model,Principal p) {
		model.addAttribute("user",p);
		return "modalTime";
	}

}
