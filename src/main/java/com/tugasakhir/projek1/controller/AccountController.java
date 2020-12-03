package com.tugasakhir.projek1.controller;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tugasakhir.projek1.model.Login;
import com.tugasakhir.projek1.model.Pembeli;
import com.tugasakhir.projek1.repository.LoginRepository;
import com.tugasakhir.projek1.repository.PembeliRepository;

@Controller
@RequestMapping("/akunPembeli")
public class AccountController {

	@Autowired
	PembeliRepository pr;
	
	@Autowired
	LoginRepository lr;

	
	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String rasaProduk(Model model,Principal p ) {
		model.addAttribute("user",p);
		
		Login Userlogin = lr.findByUsername(p.getName()).get();
		System.out.println("User yang login :"+Userlogin.getUsername());
		
		Pembeli lpembeli=pr.findByLogin(Userlogin).get();
		model.addAttribute ("pembeli", lpembeli);
		return "my-account";
	}
	
	@RequestMapping (value="/edit/{pembeli}", method = RequestMethod.GET)
	public String editProduk(Model model,Principal p,Pembeli pembeli){
		model.addAttribute("user",p);
		
		return "regis_user";

	}
	

	@RequestMapping (value="/registrasi/update", method = RequestMethod.POST)
	public String editPembeli(Pembeli pembeli) 
	{
		pr.save(pembeli);				
		return "redirect:/akunPembeli/tampil";
	}
	
	@RequestMapping (value="/request/hapusAkun/{pembeli}", method = RequestMethod.GET)
	public String requestHapus(Pembeli pembeli) 
	{
		pembeli.getLogin().setActive(false);
		pr.save(pembeli);
		return "redirect:/login";
	}


	


}
