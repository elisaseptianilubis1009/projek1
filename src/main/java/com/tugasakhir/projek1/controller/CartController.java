package com.tugasakhir.projek1.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tugasakhir.projek1.model.Cart;
import com.tugasakhir.projek1.model.Login;
import com.tugasakhir.projek1.model.Pembeli;
import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.model.ProdukMasuk;
import com.tugasakhir.projek1.repository.CartRepository;
import com.tugasakhir.projek1.repository.LoginRepository;
import com.tugasakhir.projek1.repository.PembeliRepository;
import com.tugasakhir.projek1.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartRepository cr;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	LoginRepository lr;
	
	@Autowired
	PembeliRepository pr;
	
	
	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String tampilCart(Model model,Principal p) {
	int sub=0;
	model.addAttribute("user",p);

	
	Login Userlogin = lr.findByUsername(p.getName()).get();
	System.out.println("Id User yang login :" + Userlogin.getId());//berhasil
	
	Pembeli pembeli=pr.findByLogin(Userlogin).get();
	System.out.println("Nama Pmebeli yang login :" + pembeli.getNamaLengkap());	//dapet
	
	List<Cart> pembeliCart=cr.findByPembeli(pembeli);
	model.addAttribute("cartPembeli",pembeliCart);
	
	for(Cart cart: pembeliCart) {
		sub+=cart.getTotal();
	}
	System.out.println("Subtotallllll cart :" + sub);
	model.addAttribute("subtotal",sub);
	return "cart";
	//return pembeliCart.toString;
	}
	
 
	
	@RequestMapping (value="/save/{produk}", method = RequestMethod.GET)
	public String saveCart(Produk produk,Principal p) 
	{	
		Cart cart=new Cart();
		
		Login Userlogin = lr.findByUsername(p.getName()).get();//Dapatkan objek Login
		System.out.println("Id User yang login:" + Userlogin.getId());//berhasil
		
		Pembeli pembeli=pr.findByLogin(Userlogin).get();
		System.out.println("Id Pembeli yang login :" + pembeli.getId());//dapat kok
		
		cart.setProduk(produk);
		cart.setPembeli(pembeli);
		cart.setQuantity(1);
		cart.setTotal(cart.getTotal());
		System.out.println("Total Produkkkkk :" + cart.getTotal());//dapat kok
		cr.save(cart);
		return "redirect:/cart/tampil";
		
	}
	
	@RequestMapping (value="/save/edit", method = RequestMethod.GET)
	public String saveEditCart(Cart cart,Principal p) 
	{	
		cart.setTotal(cart.getTotal());
		cr.save(cart);
		return "redirect:/cart/tampil";
		
	}
	
	
	@RequestMapping (value="/delete/{id}", method = RequestMethod.GET)
	public String deleteCart(@PathVariable Long id) {
		cr.deleteById(id);
		return "redirect:/cart/tampil";
	}
	
	
	
	@RequestMapping (value="/edit/{cart}", method = RequestMethod.GET)
	public String updateCart(Cart cart,Principal p,Model model) 
	{	
		model.addAttribute("user",p);
		model.addAttribute("cart",cart);
		
		return "Cart_Edit";
		
	}
	
	@RequestMapping (value="/allUpdate", method = RequestMethod.GET)
	public String allUpdateCart(Cart cart,Principal p) 
	{	
		cart.setTotal(cart.getTotal());
		cr.save(cart);
		return "redirect:/cart/tampil";
		
	}
	

	@RequestMapping (value="/checkout", method = RequestMethod.GET)
	public String tampilAdmin(Model model,Principal p) {
	model.addAttribute("user",p);
	
	return "checkout";
	
	}


	
}
