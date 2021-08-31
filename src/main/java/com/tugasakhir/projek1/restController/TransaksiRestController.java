package com.tugasakhir.projek1.restController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tugasakhir.projek1.Dto.saveTableTransaksiRequestDto;
import com.tugasakhir.projek1.model.Cart;
import com.tugasakhir.projek1.model.Login;
import com.tugasakhir.projek1.model.Pembeli;
import com.tugasakhir.projek1.model.Pesanan;
import com.tugasakhir.projek1.model.ProdukKeluar;
import com.tugasakhir.projek1.model.Transaksi;
import com.tugasakhir.projek1.model.TransaksiDetail;
import com.tugasakhir.projek1.repository.CartRepository;
import com.tugasakhir.projek1.repository.LoginRepository;
import com.tugasakhir.projek1.repository.PembeliRepository;
import com.tugasakhir.projek1.repository.TransaksiDetailRepository;
import com.tugasakhir.projek1.repository.TransaksiRepository;

@RestController
@RequestMapping(value = "api/transaksi")
public class TransaksiRestController {
	
	@Autowired
	LoginRepository lr;

	@Autowired
	PembeliRepository pr;

	
	@Autowired
	private TransaksiRepository transaksiRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	private TransaksiDetailRepository transaksiDetailRepository;
	
	@RequestMapping(value = "/saveTransaksi", method = RequestMethod.POST)
	public String saveStatusOrder(@RequestBody saveTableTransaksiRequestDto request,@RequestParam("orderId") String orderId, Principal p) {
		
			Login Userlogin = lr.findByUsername(p.getName()).get();// Dapatkan objek Login
			Pembeli pembeli = pr.findByLogin(Userlogin).get();
			System.out.println("Nama Lengkap : "+request.getFirs_name()+" "+request.getLast_name());
			System.out.println("Alamat : "+request.getAlamat());
			System.out.println("Telephone : "+request.getTelephone());
			System.out.println("Total : "+request.getGross_amount());

			Transaksi transaksi = new Transaksi();

			transaksi.setNamaLengkap(request.getFirs_name()+" "+request.getLast_name());
			transaksi.setAlamat(request.getAlamat());
			transaksi.setNoTelepon(request.getTelephone());
			transaksi.setOrderId(orderId);
			transaksi.setStatus("Belum dibayar");
			transaksi.setTotalPesanan(request.getGross_amount());
			transaksi.setIdPembeli(pembeli.getId());
			

			transaksiRepository.save(transaksi);
			return "Save Ke Table Transaksi Berhasil!";		
	}
	
	@RequestMapping(value = "/saveTransaksiDetail", method = RequestMethod.POST)
	public String saveTransaksiDetail(@RequestBody List<Long> cartId, @RequestParam("orderId") String orderId, Principal p) {
		
			List<TransaksiDetail> list = new ArrayList<>();

			
			for (Long cartIdx : cartId) {
				TransaksiDetail transaksiDetail = new TransaksiDetail();

				Cart cart = cartRepository.findById(cartIdx).orElse(null);
				transaksiDetail.setOrderId(orderId);
				transaksiDetail.setProduk(cart.getProduk());
				transaksiDetail.setQuantity(2);
				
				list.add(transaksiDetail);

			}

			transaksiDetailRepository.saveAll(list);
			return "Save Ke Table Transaksi Berhasil!";		
	}
	
	@RequestMapping(value = "/updateTransaksi", method = RequestMethod.POST)
	public String updateTransaksi(@RequestParam("orderId") String orderId, Principal p) {
		if(orderId==null) {
			return "order id tidak boleh kosong";
		}
		Transaksi transaksi = transaksiRepository.findByOrderId(orderId).orElse(null);
		transaksi.setStatus("Sudah dibayar (proses)");
		transaksiRepository.save(transaksi);

		return "update status transaksi berhasil";
	}


}
