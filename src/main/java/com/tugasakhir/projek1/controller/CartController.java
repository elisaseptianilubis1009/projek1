package com.tugasakhir.projek1.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tugasakhir.projek1.model.Cart;
import com.tugasakhir.projek1.model.Login;
import com.tugasakhir.projek1.model.Pembeli;
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

	@RequestMapping(value = "/tampil", method = RequestMethod.GET)
	public String tampilCart(Model model, Principal p, @RequestParam("username") String username) {
		int sub = 0, disc = 0, grandTotal = 0;
		model.addAttribute("user", p);

		Optional<Login> lg = lr.findByUsername(username);
		
		List<Cart> pembeliCart = new ArrayList<>();
		Optional<Pembeli> pembeli = Optional.ofNullable(new Pembeli());
		if (lg.isPresent()) {
			pembeli = pr.findByLogin(lg.get());
			if (pembeli.isPresent()) {
				pembeliCart = cr.findByPembeli(pembeli.get());
				model.addAttribute("cartPembeli", pembeliCart);
			}else {
				System.out.println("Pembeli tidak ditemukan");	
			}
		}else {
			System.out.println("Login tidakk ditemukan");
		}

		for (Cart cart : pembeliCart) {
			sub += cart.getTotal();
		}

		if (sub > 100000) {
			disc = 10;
			grandTotal = sub +  - (sub * 10 / 100);
		} else {
			grandTotal = sub;
		}
		model.addAttribute("subtotal", sub);
		model.addAttribute("disc", disc);
		model.addAttribute("grandTotal", grandTotal);

		System.out.println("Subtotal cart :" + sub);
		System.out.println("Diskon cart :" + disc);
		System.out.println("GrandTotal cart :" + grandTotal);
		return "cart";
		// return pembeliCart.toString;
	}

//	@RequestMapping(value = "/save/", method = RequestMethod.GET)
//	public String saveCart(Produk produk, Principal p) {
//		List<Cart> list = new ArrayList<>();
//		for (Cart cart : list) {
//			Cart c = new Cart();
//			
//			Login Userlogin = lr.findByUsername(p.getName()).get();// Dapatkan objek Login
//			System.out.println("Id User yang login:" + Userlogin.getId());// berhasil
//
//			Pembeli pembeli = pr.findByLogin(Userlogin).get();
//			System.out.println("Id Pembeli yang login :" + pembeli.getId());// dapat kok
//
//			c.setProduk(produk);
//			c.setPembeli(pembeli);
//			c.setQuantity(1);
//			c.setTotal(cart.getTotal());
//			System.out.println("Total Produkkkkk :" + cart.getTotal());// dapat kok
//			
//		}
//		cr.saveAll(list);
//
////		Login Userlogin = lr.findByUsername(p.getName()).get();// Dapatkan objek Login
////		System.out.println("Id User yang login:" + Userlogin.getId());// berhasil
////
////		Pembeli pembeli = pr.findByLogin(Userlogin).get();
////		System.out.println("Id Pembeli yang login :" + pembeli.getId());// dapat kok
////
////		cart.setProduk(produk);
////		cart.setPembeli(pembeli);
////		cart.setQuantity(1);
////		cart.setTotal(cart.getTotal());
////		System.out.println("Total Produkkkkk :" + cart.getTotal());// dapat kok
////		cr.save(cart);
//		return "redirect:/cart/tampil";
//
//	}

	@RequestMapping(value = "/save/edit", method = RequestMethod.GET)
	public String saveEditCart(Cart cart, Principal p) {
		cart.setTotal(cart.getTotal());
		cr.save(cart);
		return "redirect:/cart/tampil";

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCart(@PathVariable Long id) {
		cr.deleteById(id);
		return "redirect:/cart/tampil";
	}

	@RequestMapping(value = "/edit/{cart}", method = RequestMethod.GET)
	public String updateCart(Cart cart, Principal p, Model model) {
		model.addAttribute("user", p);
		model.addAttribute("cart", cart);

		return "Cart_Edit";

	}

	@RequestMapping(value = "/allUpdate", method = RequestMethod.GET)
	public String allUpdateCart(Cart cart, Principal p) {
		cart.setTotal(cart.getTotal());
		cr.save(cart);
		return "redirect:/cart/tampil";

	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String tampilAdmin(Model model, Principal p) {
		model.addAttribute("user", p);

		return "checkout";

	}

}
