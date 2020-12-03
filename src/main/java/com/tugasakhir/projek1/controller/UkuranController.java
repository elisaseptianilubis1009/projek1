package com.tugasakhir.projek1.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tugasakhir.projek1.model.Ukuran;
import com.tugasakhir.projek1.repository.UkuranRepository;

@Controller
@RequestMapping("/ukuran")
public class UkuranController {
	
	@Autowired
	UkuranRepository ur;
	
	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String ukuran(Model model,Principal p) {	
		model.addAttribute("user", p);
		List<Ukuran> lukuran=ur.findAll();
		model.addAttribute ("ukuran", lukuran);
		return "ukuran";
	}
	
	// CRUD UKURAN________________________________________________________________
		@RequestMapping (value="/create", method = RequestMethod.GET)
		public String tambahUkuran(Model model,Principal p) {
			model.addAttribute("user", p);
			
			model.addAttribute("ukuran",new Ukuran());
			return "Ukuran_Create"; 
		}
		
		@RequestMapping (value="/save", method = RequestMethod.POST)
		public String saveUkuran(Ukuran ukuran) {
			ur.save(ukuran);
			return "redirect:/ukuran/tampil";
		}
		
		@RequestMapping (value="/edit/{ukuran}", method = RequestMethod.GET)
		public String editUkuran(Model model, Ukuran ukuran, Principal p) {
			model.addAttribute("user", p);
			return "Ukuran_Create";
		}

		@RequestMapping (value="/delete/{id}", method = RequestMethod.GET)
		public String deleteUkuran(@PathVariable Long id) {
			ur.deleteById(id);
			return "redirect:/ukuran/tampil";
		}



}
