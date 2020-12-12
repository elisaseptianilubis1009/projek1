package com.tugasakhir.projek1.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tugasakhir.projek1.model.Rasa;
import com.tugasakhir.projek1.repository.RasaRepository;
import com.tugasakhir.projek1.service.RasaService;

@Controller
@RequestMapping("/rasa")
public class RasaController {
    
	@Autowired
	RasaRepository rr;
	
	@Autowired
	RasaService rs;

	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String rasaProduk(Model model,Principal p) {
		model.addAttribute("user",p);

		List<Rasa> lrasa=rr.findAll();
		model.addAttribute ("rasa", lrasa);
		return "rasa";
	}
	
	//CRUD RASA______________________________________________________________
	  
	@RequestMapping (value="/create", method = RequestMethod.GET)
	public String tambah_rasa(Model model,Principal p) {
		model.addAttribute("user",p);
		
		model.addAttribute("rasa",new Rasa());
		return "Rasa_Create"; 
	}
	
	
	@RequestMapping (value="/save", method = RequestMethod.POST)
	public String save_rasa(Rasa rasa,@RequestParam("pfile") MultipartFile file) {
		
		rs.saveRasa(rasa,file);
		return "redirect:/rasa/tampil";
	}
	
	
	
	@RequestMapping (value="/edit/{rasa}", method = RequestMethod.GET)
	public String edit_rasa(Model model,Rasa rasa,Principal p) {
		model.addAttribute("user",p);
		return "Rasa_Create";
	}

	@RequestMapping (value="/delete/{id}", method = RequestMethod.GET)
	public String delete_rasa(@PathVariable Long id) {
		rr.deleteById(id);
		return "redirect:/rasa/tampil";
	}
}
