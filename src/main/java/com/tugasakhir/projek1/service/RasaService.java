package com.tugasakhir.projek1.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.tugasakhir.projek1.model.Rasa;
import com.tugasakhir.projek1.repository.RasaRepository;

@Service
public class RasaService {
	@Autowired
	private RasaRepository rr; 
	
	public void saveRasa(Rasa rasa,MultipartFile file) 
	
	{
		String fileName= StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) 
		{
			System.out.println("not a valid file");
		}
		try {
			rasa.setGambar(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	rr.save(rasa);
	}
	

}
