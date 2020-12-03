package com.tugasakhir.projek1.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tugasakhir.projek1.model.Admin;
import com.tugasakhir.projek1.model.Login;
import com.tugasakhir.projek1.repository.AdminRepository;
import com.tugasakhir.projek1.repository.LoginRepository;
import com.tugasakhir.projek1.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminRepository adm;
	
	@Autowired
	LoginRepository lgn;
	
	@Autowired
	AdminService adminService;

	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String tampilAdmin(Model model,Principal p) {
	model.addAttribute("user",p);
	
	List<Admin> ladmin=adm.findAll();
	model.addAttribute("admin", ladmin);
	return "admin";
	
	}
	
	//CRUD PEMBELI __________________________________________________________________

			@RequestMapping (value="/create", method = RequestMethod.GET)
			public String tambahAdmin(Model model,Principal p) {
				model.addAttribute("user", p);
				
				Admin admin = new Admin();
				Login login = new Login();
				admin.setLogin(login);
				admin.getLogin().setAkses("ADMIN");
				admin.getLogin().setActive(true);
				model.addAttribute("admin",admin);
				
				return "Admin_Create"; 
			}
			
			
			@RequestMapping (value="/save", method = RequestMethod.POST)
			public String saveAdmin(Admin admin)
			{	
				adm.save(admin);
				return "redirect:/admin/tampil";
			}
				
			@RequestMapping (value="/edit/{admin}", method = RequestMethod.GET)
			public String editAdmin(Model model,Admin admin,Principal p) 
			{
				model.addAttribute("user", p);
				return "Admin_Create";
			}
			
			
			@RequestMapping (value="/delete/{id}/{idLogin}", method = RequestMethod.GET)
			public String deleteAdmin(@PathVariable Long id) {
				adm.deleteById(id);
				return "redirect:/admin/tampil";
			}


}
