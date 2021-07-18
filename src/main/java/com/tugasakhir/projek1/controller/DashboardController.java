package com.tugasakhir.projek1.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tugasakhir.projek1.model.Login;
import com.tugasakhir.projek1.repository.LoginRepository;
import com.tugasakhir.projek1.repository.PembeliRepository;

@Controller
public class DashboardController {
	
	@Autowired
	PembeliRepository pbl;
	
	@Autowired
	private LoginRepository loginRepo;

	@RequestMapping (value="/", method = RequestMethod.GET)
	public String tampil_admin(Model model,Principal p) {	
		model.addAttribute("user",p);
		Login login = loginRepo.cekRole(p.getName());
		System.out.println("GET NAMEM=========:"+p.getName());
		System.out.print("NILAI LOGIN========:"+login);
		if(login!=null)
			if(login.getAkses().equals("ADMIN")) 
				return "index";
		
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
	
	@RequestMapping (value="/contact-us", method = RequestMethod.GET)
	public String contact(Model model,Principal p) {	
		model.addAttribute("user",p);
	return "contact-us";
	}
	
	
}
