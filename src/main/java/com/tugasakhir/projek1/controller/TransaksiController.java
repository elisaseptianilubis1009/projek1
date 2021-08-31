package com.tugasakhir.projek1.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tugasakhir.projek1.model.Login;
import com.tugasakhir.projek1.model.Pembeli;
import com.tugasakhir.projek1.model.ProdukKeluar;
import com.tugasakhir.projek1.model.Transaksi;
import com.tugasakhir.projek1.model.TransaksiDetail;
import com.tugasakhir.projek1.repository.LoginRepository;
import com.tugasakhir.projek1.repository.PembeliRepository;
import com.tugasakhir.projek1.repository.ProdukKeluarRepository;
import com.tugasakhir.projek1.repository.RasaRepository;
import com.tugasakhir.projek1.repository.TransaksiDetailRepository;
import com.tugasakhir.projek1.repository.TransaksiRepository;


@Controller
@RequestMapping("/transaksi")
public class TransaksiController {
	
	@Autowired
	TransaksiRepository transaksiRepository;
	
	@Autowired
	private TransaksiDetailRepository transaksiDetailRepository;
	
	@Autowired
	LoginRepository lr;

	@Autowired
	PembeliRepository pr;
	
	@Autowired
	RasaRepository rasaRepository;
	
	@Autowired
	private ProdukKeluarRepository produkKeluarRepository;
	
	@RequestMapping(value = "/tampil", method = RequestMethod.GET)
	public String tampilAdmin(Model model, Principal p) {
		
		model.addAttribute("user", p);
		Login Userlogin = lr.findByUsername(p.getName()).get();// Dapatkan objek Login
		Pembeli pembeli = pr.findByLogin(Userlogin).get();
		List<Transaksi> transaksi=transaksiRepository.findByIdPembeli(pembeli.getId());
		model.addAttribute("transaksi", transaksi); 
		
	
		
		return "transaksi";

	}
	
	@RequestMapping(value = "/detail/{orderId}", method = RequestMethod.GET)
	public String detailTransaksi(@PathVariable String orderId,Model model, Principal p) {
				
		model.addAttribute("user", p);
		List<TransaksiDetail> transaksiDetail=transaksiDetailRepository.findByOrderId(orderId);
		
		model.addAttribute("transaksiDetail", transaksiDetail); 
		
		return "transaksiDetail";

	}

}
