package com.tugasakhir.projek1.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tugasakhir.projek1.model.Akun;
import com.tugasakhir.projek1.repository.AkunRepository;

@Controller
@RequestMapping("/akun")
public class AkunController {
	
	@Autowired
	private AkunRepository akunRepository;
	
	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String rasaProduk(Model model,Principal p) {
		model.addAttribute("user",p);

		List<Akun> lakun=akunRepository.findAll();
		model.addAttribute ("akun", lakun);
		return "akun";
	}
	

}
