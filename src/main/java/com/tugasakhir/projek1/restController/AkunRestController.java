package com.tugasakhir.projek1.restController;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tugasakhir.projek1.Dto.AkunRequestDto;
import com.tugasakhir.projek1.model.Akun;
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
	
	@RequestMapping(value = "/saveAkun", method = RequestMethod.POST)
	public String saveAkun(@RequestBody AkunRequestDto request, Principal p) {
		
			Akun akun = new Akun();
			
			akun.setNamaAkun(request.getNama_akun());
			akun.setNominal(request.getNominal());
			akun.setKeteranganAkun(request.getKet_akun());
			akun.setBulan(request.getMonth());
			akun.setTahun(request.getYear());
			
			System.out.println("nama_akun :"+akun.getNamaAkun());
			System.out.println("Object Akun : "+akun);

			akunRepository.save(akun);		

			return "Success";	
		
	}
	
	@RequestMapping(value = "/updateAkun", method = RequestMethod.POST)
	public String updateAkun(@RequestBody AkunRequestDto request, @RequestParam("idAkun") Long idAkun,Principal p) {
		
			Akun akun = akunRepository.findById(idAkun).orElse(null);
			System.out.println("nominal :"+request.getNominal());
			System.out.println("month :"+request.getMonth());
			System.out.println("year :"+request.getYear());
			System.out.println("idAkun : "+idAkun);
			
			akun.setNominal(request.getNominal());
			akun.setBulan(request.getMonth());
			akun.setTahun(request.getYear());
			
			akunRepository.save(akun);
			

			return "Success";	
		
	}
	
	@RequestMapping(value = "/deleteAkun", method = RequestMethod.POST)
	public String deleteAkun(@RequestParam("idAkun") Long idAkun,Principal p) {
		
			Akun akun = akunRepository.findById(idAkun).orElse(null);
			
			
			akunRepository.delete(akun);
			

			return "Success";	
		
	}


}
