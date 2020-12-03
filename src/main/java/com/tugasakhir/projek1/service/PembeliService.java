package com.tugasakhir.projek1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tugasakhir.projek1.model.Pembeli;
import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.repository.PembeliRepository;

@Service
public class PembeliService {
	
	@Autowired
	PembeliRepository repoPembeli;
	

}
