package com.tugasakhir.projek1.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tugasakhir.projek1.model.Pembeli;
import com.tugasakhir.projek1.repository.LoginRepository;
import com.tugasakhir.projek1.repository.PembeliRepository;

@Controller
@RequestMapping("/pembeli")
public class PembeliController {
		
		@Autowired
		PembeliRepository pr;

		@Autowired
		LoginRepository lr;

		@RequestMapping (value="/tampil", method = RequestMethod.GET)
		public String tampil_pembeli(Model model,Principal p) {
			model.addAttribute("user",p);
			
			List<Pembeli> lpembeli=pr.findAll();
			model.addAttribute("pembeli", lpembeli);
			return "pembeli";
		}


//DELETE PEMBELI
		
		@RequestMapping (value="/delete/{id}", method = RequestMethod.GET)
		public String deletePembeli(@PathVariable Long id) 
		{
			pr.deleteById(id);
			return "redirect:/pembeli/tampil";
		}



}







//pembeli = pbl.findById(Long.valueOf("1")).get(); (FORMAT SELECT DENGAN PARAMATERE INTEGER/LONG)
//
//System.out.println("Nama : " + pembeli.getNama_lengkap());
//System.out.println("Username : " + pembeli.getLogin().getUsername());
//System.out.println("Password : " +  pembeli.getLogin().getPassword());
