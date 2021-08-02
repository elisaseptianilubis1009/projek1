package com.tugasakhir.projek1.restController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tugasakhir.projek1.model.Cart;
import com.tugasakhir.projek1.model.Login;
import com.tugasakhir.projek1.model.Pembeli;
import com.tugasakhir.projek1.model.Pesanan;
import com.tugasakhir.projek1.model.Produk;
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


	/*@RequestMapping(value = "/savePesanan", method = RequestMethod.POST)
	public String savePesanan(@RequestBody List<ProdukKeluarRequestDto> request, @RequestParam("orderId") String orderId, Principal p) {

		System.out.println("ProdukKeluarRequestDto :"+request);
		List<ProdukKeluar> list = new ArrayList<>();

		for (ProdukKeluarRequestDto cartIdx :request ) {
			ProdukKeluar produkKeluar = new ProdukKeluar();
			
//			Cart cart =crRepo.findById(cartIdx.getCartQuantityRequestDto());
	

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
	}*/
	
	
//@RequestBody List<Long> cartId
//@RequestParam("orderId") String orderId,
//@RequestBody List<Integer> 
		@RequestMapping(value = "/savePesanan", method = RequestMethod.POST)
		public String savePesanan(@RequestBody List<Long> cartId, @RequestParam("orderId") String orderId, Principal p) {


			List<ProdukKeluar> list = new ArrayList<>();

			for (Long cartIdx :cartId ) {
				ProdukKeluar produkKeluar = new ProdukKeluar();
				
				Cart cart =crRepo.findById(cartIdx).orElse(null);
			

				produkKeluar.setProduk(cart.getProduk());
				produkKeluar.setOrderId(orderId);
				produkKeluar.setStatus(false);
				produkKeluar.setQuantity(2);
				list.add(produkKeluar);

			}
			System.out.println("Success save produk keluar: " + list);
			produkKeluarRepository.saveAll(list);
			return "Success save produkKeluar";
		}
		
		
		@RequestMapping(value = "/updateConfirm", method = RequestMethod.POST)
		public String updateConfirm(@RequestBody String orderId, Principal p) {
			System.out.println("===== Produk Id _____:" + orderId);
			List<ProdukKeluar> produkKeluar=produkKeluarRepository.findByOrderId(orderId);
			System.out.println("sizekita :"+produkKeluar.size());

			int a=0;
			for (ProdukKeluar data : produkKeluar) {
				
				ProdukKeluar produkKel = produkKeluarRepository.findByKode(data.getKode()).orElse(null);
				
				System.out.println("Order Id" + data.getOrderId());
				produkKel.setStatus(true);
		
				produkKeluarRepository.save(produkKel);
				System.out.println("Status : "+produkKel.isStatus());
				a++;
			};
			return "Success save produk";
		}
		
		
		
		@RequestMapping(value = "/updateConfirmPesanan", method = RequestMethod.POST)
		public String updateConfirmPesanan(@RequestBody String orderId, Principal p) {
	

				
				Pesanan pesanan = pesananRepository.findByOrderId(orderId).orElse(null);
				pesanan.setStatusConfirmation("confirmed");
				pesanan.setColor("#81f23a");
		
				pesananRepository.save(pesanan);
			
			return pesanan.getStatusConfirmation();
		}
		

}
