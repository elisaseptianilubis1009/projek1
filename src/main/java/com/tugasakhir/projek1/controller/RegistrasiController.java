package com.tugasakhir.projek1.controller;

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
public class RegistrasiController {

	@Autowired
	PembeliRepository pr;
	
	@Autowired
	LoginRepository lr;
	
//CRUD REGISTRASI __________________________________________________________________

			@RequestMapping (value="/registrasi", method = RequestMethod.GET)
			public String registrasiUser(Model model) 
			{	
				Pembeli pembeli=new Pembeli();
				Login login=new Login ();
				pembeli.setLogin(login);	
				pembeli.getLogin().setAkses("PEMBELI"); 
				pembeli.getLogin().setActive(true);
				model.addAttribute("pembeli", pembeli);
				
				return "regis_user"; 
			}
			
			
			
			@RequestMapping (value="/registrasi/save", method = RequestMethod.POST)
			public String savePembeli(Pembeli pembeli) 
			{
				pr.save(pembeli);				
				return "redirect:/registrasi";
			}
			

}
