package com.tugasakhir.projek1.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tugasakhir.projek1.model.ProdukKeluar;
import com.tugasakhir.projek1.repository.ProdukKeluarRepository;

@RestController
@RequestMapping(value = "api/produkkeluar")
public class ProdukKeluarRestController {
	
	@Autowired
	private ProdukKeluarRepository produkKeluarRepository;
	

	@GetMapping("/getAll")
	public List<ProdukKeluar> allProdukKeluar() {
		return produkKeluarRepository.findAll();
	}
}
