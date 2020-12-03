package com.tugasakhir.projek1.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tugasakhir.projek1.repository.PembeliRepository;

@Controller
public class DashboardController {
	
	@Autowired
	PembeliRepository pbl;

	@RequestMapping (value="/", method = RequestMethod.GET)
	public String tampil_admin(Model model,Principal p) {	
		model.addAttribute("user",p);
	return "index_user";
	}
	
	@RequestMapping (value="/index_user", method = RequestMethod.GET)
	public String indexn(Model model,Principal p) {	
		model.addAttribute("user",p); 
	return "index_user";
	}
	
	@RequestMapping (value="/index", method = RequestMethod.GET)
	public String indexAdmin(Model model,Principal p) {	
		model.addAttribute("user",p); 
	return "index";
	}
	
	@RequestMapping (value="/about", method = RequestMethod.GET)
	public String about(Model model,Principal p) {	
		model.addAttribute("user",p);
	return "about";
	}
	
	@RequestMapping (value="/gallery", method = RequestMethod.GET)
	public String galery(Model model,Principal p) {	
		model.addAttribute("user",p);
	return "gallery";
	}
}
