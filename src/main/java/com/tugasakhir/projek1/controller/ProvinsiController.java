package com.tugasakhir.projek1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.tugasakhir.projek1.model.Provinsi;
import com.tugasakhir.projek1.repository.ProvinsiRepository;

	@Controller
	@RequestMapping("/provinsi")
	public class ProvinsiController {
	@Autowired
	ProvinsiRepository prov;
	
	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String provinsi(Model model) {	
		List<Provinsi> lprovinsi=prov.findAll();
		model.addAttribute ("provinsi", lprovinsi);
		return "provinsi";
	}
	
//CRUD PROVINSI______________________________________________________________
	
	@RequestMapping (value="/create", method = RequestMethod.GET)
	public String tambah_prov(Model model) {
		model.addAttribute("provinsi",new Provinsi());
		return "Provinsi_Create"; 
	}
	
	@RequestMapping (value="/create", method = RequestMethod.POST)
	public String save_prov(Provinsi provinsi) {
		prov.save(provinsi);
		return "redirect:/provinsi/tampil";
	}
	
	@RequestMapping (value="/edit/{id}", method = RequestMethod.GET)
	public String edit_provinsi(Model model, @PathVariable Long id) {
	Provinsi provinsi = prov.findById(id).get();
		model.addAttribute("provinsi",provinsi);
		return "Provinsi_Create";
	}

	@RequestMapping (value="/delete/{id}", method = RequestMethod.GET)
	public String delete_prov(@PathVariable Long id) {
		prov.deleteById(id);
		return "redirect:/provinsi/tampil";
	}

	

	

	
}
