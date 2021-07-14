package com.tugasakhir.projek1.restController;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tugasakhir.projek1.model.Cart;
import com.tugasakhir.projek1.model.Login;
import com.tugasakhir.projek1.model.Pembeli;
import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.model.ProdukKeluar;
import com.tugasakhir.projek1.model.ProdukMasuk;
import com.tugasakhir.projek1.model.Rasa;
import com.tugasakhir.projek1.repository.CartRepository;
import com.tugasakhir.projek1.repository.LoginRepository;
import com.tugasakhir.projek1.repository.PembeliRepository;
import com.tugasakhir.projek1.repository.ProdukKeluarRepository;
import com.tugasakhir.projek1.repository.ProdukMasukRepository;
import com.tugasakhir.projek1.repository.ProdukRepository;
import com.tugasakhir.projek1.repository.RasaRepository;
import com.tugasakhir.projek1.service.CartService;
import com.tugasakhir.projek1.service.ProdukService;

@RestController
@RequestMapping(value = "api/cart")
public class CartRestController {

	@Autowired
	private CartService cartService;

	@Autowired
	CartRepository crRepo;

	@Autowired
	LoginRepository lr;

	@Autowired
	PembeliRepository pr;

	@Autowired
	ProdukRepository produkRepo;
	
	@Autowired
	private ProdukMasukRepository produkMasukRepository;
	
	@Autowired
	private ProdukKeluarRepository produkKeluarRepository;

	@Autowired
	RasaRepository rr;
	@Autowired
	private ProdukService produkService;
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> find(@PathVariable("id") Long id) {

		try {
			return new ResponseEntity<Cart>(cartService.find(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Cart>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/getProduk")
	public List<Produk> allAproduk() {
		return produkService.findAllProduk();
	}
	
	@GetMapping("/getProduk/{rasa}")
	public List<Produk> allAprodukByRasa(@PathVariable("rasa") Long rasa) {
		Rasa r = rr.findById(rasa).orElse(null);
		List<Produk> listP = produkService.findAllProdukByRasa(r);
		for(Produk p: listP) {
			List<ProdukMasuk> list = produkMasukRepository.findAllByProduk(p);
			List<ProdukKeluar> listProdukKeluar = produkKeluarRepository.findAllByProduk(p);
			Integer stok = 0;
			for(ProdukMasuk pm:list) {
				stok+=pm.getJumlahProdukMasuk();
			}
			for(ProdukKeluar pk:listProdukKeluar) {
				stok-=pk.getJumlahProdukKeluar();
			}
			p.setStok(stok);
		}
		return listP;
	}
	
	@GetMapping("/getCart/{username}")
	public List<Cart> allCartByUser(@PathVariable("username") String username) {

		Optional<Login> lg=lr.findByUsername(username);
		Pembeli pl = pr.findByLogin(lg.get()).orElse(null);
		List<Cart> listCart = cartService.findAllCartByUser(pl);
		
		return listCart;
	}

	@RequestMapping(value = "/saveCart", method = RequestMethod.POST)
	public String saveCart(@RequestBody List<Long> produkId, Principal p) {
		System.out.println("=====" + produkId);
		List<Cart> list = new ArrayList<>();
		for (Long id : produkId) {
			System.out.println("ID 1 =" + id);
			Cart c = new Cart();

			Login Userlogin = lr.findByUsername(p.getName()).get();// Dapatkan objek Login
			System.out.println("Id User yang login:" + Userlogin.getId());// berhasil

			Pembeli pembeli = pr.findByLogin(Userlogin).get();
			System.out.println("Id Pembeli yang login :" + pembeli.getId());// dapat kok
			System.out.println("ID 2 =" + id);

			Produk produk = produkRepo.findById(id).orElse(null);
			c.setKode(id);
			c.setProduk(produk);
			c.setPembeli(pembeli);
			c.setQuantity(1);
			c.setTotal(6);
			list.add(c);
//			System.out.println("Total Produkkkkk :" + cart.getTotal());// dapat kok

		}
		System.out.println("Success : " + list);
		crRepo.saveAll(list);
		return "Success save produk";
	}

	@GetMapping("/city")
	public ResponseEntity<String> province() {
		RestTemplate restTemplate = new RestTemplate();
	     
		final String baseUrl = "https://api.rajaongkir.com/starter/city";
		URI uri=null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		     
		HttpHeaders headers = new HttpHeaders();
		headers.set("key", "2fb78e4fd381c4f967b1f4a1b9a1dfd3");  
		 
		HttpEntity<?> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		  
		return result;
	}
	
	@PostMapping("/cost")
	public ResponseEntity<String> cost(@RequestBody CostRequestDto request) {
		RestTemplate restTemplate = new RestTemplate();
	    System.out.println("Req++++++++++++++++:"+request);
		final String baseUrl = "https://api.rajaongkir.com/starter/cost";
		URI uri=null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("key", "2fb78e4fd381c4f967b1f4a1b9a1dfd3");  
		 
		HttpEntity<?> requestEntity = new HttpEntity<>(request, headers);
		 
		ResponseEntity<String> result = restTemplate.postForEntity(uri,  requestEntity, String.class);
		  
		return result;
	}
	
	
	@RequestMapping(value = "/subTotal", method = RequestMethod.POST)
	public String subTotal(@RequestBody List<TotalRequestDto> request,Principal principal) {
	
		List<Cart> list = new ArrayList<>();
		Integer sum = 0;
		for (TotalRequestDto req : request) {
			Cart c = crRepo.findById(req.getCode()).orElse(null);
			int total = c.getProduk().getHargaJual()*req.getQuantity();
			sum += total;			
		}
		System.out.println("Success : " + list);
		return "Sub Total : "+sum;
	}

	@PostMapping("/transaction")
	public ResponseEntity<TransactionResponseDto> orderRequest(@RequestBody OrderRequestDto request) {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "https://app.sandbox.midtrans.com/snap/v1/transactions";
		URI uri=null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic U0ItTWlkLXNlcnZlci0ya0ViNGFEeXpkdG1uTlo4bVdlNEV1NzM6");  
		headers.set("Accept", "application/json");  
		headers.set("Content-Type", "application/json");  
		 
		HttpEntity<?> requestEntity = new HttpEntity<>(request, headers);
		 
		ResponseEntity<TransactionResponseDto> result = restTemplate.postForEntity(uri,  requestEntity, TransactionResponseDto.class);
		  
		return result;
	}
	

}
