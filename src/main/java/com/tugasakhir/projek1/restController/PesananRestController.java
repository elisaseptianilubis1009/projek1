package com.tugasakhir.projek1.restController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tugasakhir.projek1.model.Pesanan;
import com.tugasakhir.projek1.repository.PesananRepository;
import com.tugasakhir.projek1.service.PesananService;

@RestController
@RequestMapping(value = "api/pesanan")
public class PesananRestController {

	@Autowired
	private PesananService pesananService;
	
	@Autowired
	private PesananRepository pesananRepository;
	
	
	
	@GetMapping("/getPesanan")
	public List<Pesanan> allAPesanan() {
		return pesananRepository.findAll();
	}
}
