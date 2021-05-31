package com.tugasakhir.projek1.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.model.Rasa;
import com.tugasakhir.projek1.repository.ProdukRepository;

@Service
public class ProdukService {
	@Autowired
	private ProdukRepository pr; 
	
	public void saveProduct(Produk produk,MultipartFile file) 
	
	{
		String fileName= StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) 
		{
			System.out.println("not a valid file");
		}
		try {
			produk.setGambar(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	pr.save(produk);
	}
	
	
	
	
	public Page<Produk> findPaginated(int pageNo,int pageSize){
		Pageable pageable= PageRequest.of(pageNo - 1, pageSize);
		return this.pr.findAll(pageable);
	}
	
	public List<Produk> findAllProduk(){
		return pr.findAll();
	}
	
	public List<Produk> findAllProdukByRasa(Rasa rasa){
		return pr.findByRasa(rasa);
	}

}
