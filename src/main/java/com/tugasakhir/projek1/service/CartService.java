package com.tugasakhir.projek1.service;

import java.io.IOException;
import java.security.Principal;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tugasakhir.projek1.model.Cart;
import com.tugasakhir.projek1.model.Login;
import com.tugasakhir.projek1.model.Pembeli;
import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.repository.CartRepository;
import com.tugasakhir.projek1.repository.LoginRepository;
import com.tugasakhir.projek1.repository.PembeliRepository;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	LoginRepository lr;
	
	@Autowired
	PembeliRepository pr;
	
public void saveCart(Produk produk,Principal p) 
	{	
		Cart cart=new Cart();
		
		Login Userlogin = lr.findByUsername(p.getName()).get();//Dapatkan objek Login
		System.out.println("Id User yang login :" + Userlogin.getId());//Menampilkan idUser yang sedang login
		
		Pembeli pembeli=pr.findByLogin(Userlogin).get();
		System.out.println("Id Pembeli yang login :" + pembeli.getId());
		
		cart.setProduk(produk);
		cart.setPembeli(pembeli);

		cartRepository.save(cart);
		
	}


public Cart find(Long id) {
	return cartRepository.findById(id).get();
}





//		System.out.println("User yang login :" + userLogin.getId());
//    	Pembeli pembeli=
//		cart.setPembeli(pembeli);
		
	
		
	

}
