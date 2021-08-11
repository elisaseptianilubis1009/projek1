package com.tugasakhir.projek1.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tugasakhir.projek1.model.Akun;
import com.tugasakhir.projek1.model.Pesanan;
import com.tugasakhir.projek1.repository.AkunRepository;

@RestController
@RequestMapping(value = "api/akun")
public class AkunRestController {
	
	@Autowired
	private AkunRepository akunRepository;
	
	@GetMapping("/getAkun")
	public List<Akun> allAkun() {
		return akunRepository.findAll();
	}

}
