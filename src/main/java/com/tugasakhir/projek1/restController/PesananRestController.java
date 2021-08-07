package com.tugasakhir.projek1.restController;

import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tugasakhir.projek1.Dto.ExportToExcelRequestDto;
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

	@GetMapping("/getProdukKeluarByKode")
	public List<ExportToExcelRequestDto> produkKeluar() {
		List<Object[]> produkKeluar = produkKeluarRepository.reportProduk();
		List<ExportToExcelRequestDto> dtos = new ArrayList<ExportToExcelRequestDto>();
		for (Object[] objects : produkKeluar) {
			ExportToExcelRequestDto dto= new ExportToExcelRequestDto();
			dto.setNamaProduk(objects[0].toString());
			dto.setQuantity(Integer.parseInt(objects[1].toString()));
			dto.setTotal(Integer.parseInt(objects[2].toString()));
			
			dtos.add(dto);
		}
		return dtos;
	}

	/*
	 * @RequestMapping(value = "/savePesanan", method = RequestMethod.POST) public
	 * String savePesanan(@RequestBody List<ProdukKeluarRequestDto>
	 * request, @RequestParam("orderId") String orderId, Principal p) {
	 * 
	 * System.out.println("ProdukKeluarRequestDto :"+request); List<ProdukKeluar>
	 * list = new ArrayList<>();
	 * 
	 * for (ProdukKeluarRequestDto cartIdx :request ) { ProdukKeluar produkKeluar =
	 * new ProdukKeluar();
	 * 
	 * // Cart cart =crRepo.findById(cartIdx.getCartQuantityRequestDto());
	 * 
	 * 
	 * // Cart cart =
	 * crRepo.findById(produkKeluarRequestDto.getCartQuantityRequestDto()).orElse(
	 * null); // System.out.println("cartId___: " +
	 * cartQuantityRequestDto.getCartId()); // System.out.println("qty___: " +
	 * cartQuantityRequestDto.getQuantity()); // produkKeluar.setConfirm(false); //
	 * produkKeluar.setProduk(cart.getProduk()); //
	 * produkKeluar.setQuantity(cartQuantityRequestDto.getQuantity());
	 * 
	 * list.add(produkKeluar);
	 * 
	 * } System.out.println("Success save produk keluar: " + list);
	 * produkKeluarRepository.saveAll(list); return "Success save produkKeluar"; }
	 */

//@RequestBody List<Long> cartId
//@RequestParam("orderId") String orderId,
//@RequestBody List<Integer> 
	@RequestMapping(value = "/savePesanan", method = RequestMethod.POST)
	public String savePesanan(@RequestBody List<Long> cartId, @RequestParam("orderId") String orderId, Principal p) {

		List<ProdukKeluar> list = new ArrayList<>();

		for (Long cartIdx : cartId) {
			ProdukKeluar produkKeluar = new ProdukKeluar();

			Cart cart = crRepo.findById(cartIdx).orElse(null);

			produkKeluar.setProduk(cart.getProduk());
			produkKeluar.setOrderId(orderId);
			produkKeluar.setStatus(false);
			produkKeluar.setStatusConfirmation("Waiting for Confirmation");
			produkKeluar.setColor("#ff0000");
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
		List<ProdukKeluar> produkKeluar = produkKeluarRepository.findByOrderId(orderId);
		System.out.println("sizekita :" + produkKeluar.size());

		int a = 0;
		for (ProdukKeluar data : produkKeluar) {

			ProdukKeluar produkKel = produkKeluarRepository.findByKode(data.getKode()).orElse(null);

			System.out.println("Order Id" + data.getOrderId());
			produkKel.setStatus(true);
			produkKel.setStatusConfirmation("Confirmed");
			produkKel.setColor("#2962fb");

			produkKeluarRepository.save(produkKel);
			System.out.println("Status : " + produkKel.isStatus());
			a++;
		}
		;
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
	
	@GetMapping("/export")
    public void exportToExcel(HttpServletResponse response) throws IOException {
		List<Object[]> produkKeluar = produkKeluarRepository.reportProduk();
		List<ExportToExcelRequestDto> dtos = new ArrayList<ExportToExcelRequestDto>();
		Integer granTotal=0;
		for (Object[] objects : produkKeluar) {
			ExportToExcelRequestDto dto= new ExportToExcelRequestDto();
			dto.setNamaProduk(objects[0].toString());
			dto.setQuantity(Integer.parseInt(objects[1].toString()));
			dto.setTotal(Integer.parseInt(objects[2].toString()));
			
			granTotal+=dto.getTotal();
			dtos.add(dto);
		}
		System.out.println("GRAND TOTAL : "+granTotal);
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Laporan_Penjualan_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

//        List<User> listUsers = service.listAll();
//        ExcellExporter excelExporter = new ExcelExporter(dtos);
        ExcellExporter excelExporter = new ExcellExporter(dtos,granTotal);

        excelExporter.export(response);
    }

}
