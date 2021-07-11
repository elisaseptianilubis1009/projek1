package com.tugasakhir.projek1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugasakhir.projek1.model.Admin;
import com.tugasakhir.projek1.model.Login;
import com.tugasakhir.projek1.repository.AdminRepository;
import com.tugasakhir.projek1.repository.LoginRepository;

@Service
public class AdminService{
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	LoginRepository loginRepository;
	 
	public void saveAdmin(Admin admin,Login login) 
	{ 
		login.setAkses("ADMIN");
		login.setActive(true);
		loginRepository.save(login);

		admin.setLogin(login);
		adminRepository.save(admin);
		
		
		
	}

}
