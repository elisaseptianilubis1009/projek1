package com.tugasakhir.projek1.restController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tugasakhir.projek1.model.Pesanan;
import com.tugasakhir.projek1.model.ProdukKeluar;
import com.tugasakhir.projek1.repository.CartRepository;
import com.tugasakhir.projek1.repository.PesananRepository;
import com.tugasakhir.projek1.repository.ProdukKeluarRepository;
import com.tugasakhir.projek1.service.PesananService;

@RestController
@RequestMapping(value = "api/pesanan")
public class PesananRestController {

	@Autowired
	private PesananService pesananService;
	
	@Autowired
	private PesananRepository pesananRepository;
	
	@Autowired
	CartRepository crRepo;
	
	@Autowired
	private ProdukKeluarRepository produkKeluarRepository;
	
	@GetMapping("/getPesanan")
	public List<Pesanan> allAPesanan() {
		return pesananRepository.findAll();
	}
	
//	@RequestBody List<Integer> 
	@RequestMapping(value = "/savePesanan", method = RequestMethod.POST)
	public String savePesanan(@RequestBody List<ProdukKeluarRequestDto> request, Principal p) {

		List<ProdukKeluar> list = new ArrayList<>();
		
		for (ProdukKeluarRequestDto produkKeluarRequestDto : request) {
			System.out.println("Masukkkkkkkk euy_____________");
			ProdukKeluar produkKeluar = new ProdukKeluar();
			
			CartQuantityRequestDto cr=new CartQuantityRequestDto();
				
//			Cart cart = crRepo.findById(produkKeluarRequestDto.getCartQuantityRequestDto()).orElse(null);
//			System.out.println("cartId___: " + cartQuantityRequestDto.getCartId());
//			System.out.println("qty___: " + cartQuantityRequestDto.getQuantity());
//			produkKeluar.setConfirm(false);
//			produkKeluar.setProduk(cart.getProduk());
//			produkKeluar.setQuantity(cartQuantityRequestDto.getQuantity());

			list.add(produkKeluar);

		}
		System.out.println("Success save produk keluar: " + list);
		produkKeluarRepository.saveAll(list);
		return "Success save produkKeluar";
	}
}
