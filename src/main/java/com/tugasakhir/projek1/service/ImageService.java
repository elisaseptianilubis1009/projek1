package com.tugasakhir.projek1.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tugasakhir.projek1.model.Image;
import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.repository.ImageRepository;

@Service
public class ImageService {
	@Autowired
	ImageRepository imageRepository;
	
public void saveImage(Image image,MultipartFile file) 
	
	{
		String fileName= StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) 
		{
			System.out.println("not a valid file");
		}
		try {
			image.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		imageRepository.save(image);
	}


	
	public Page<Image> findPaginated(int pageNo,int pageSize){
		Pageable pageable= PageRequest.of(pageNo - 1, pageSize);
		return this.imageRepository.findAll(pageable);
	}
	
	

}
