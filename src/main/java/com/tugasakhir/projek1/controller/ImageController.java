package com.tugasakhir.projek1.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tugasakhir.projek1.model.Image;
import com.tugasakhir.projek1.model.Rasa;
import com.tugasakhir.projek1.repository.ImageRepository;
import com.tugasakhir.projek1.repository.RasaRepository;
import com.tugasakhir.projek1.service.ImageService;

@Controller
@RequestMapping("/image")
public class ImageController {
	
	@Autowired
	ImageRepository img;
	
	@Autowired
	RasaRepository rs;
	
	@Autowired
	ImageService imageService;
	
	//USER
	@RequestMapping (value="/tampil/all",method = RequestMethod.GET)
	public String all (Model model,Principal p) {
		model.addAttribute("user",p);
		List<Image> all=img.findAll();
		model.addAttribute("all", all);
		
		return "gallery";
	}
	
	@RequestMapping (value="/tampil/macok/{id}",method = RequestMethod.GET)
	public String macok (Model model,Principal p,  @PathVariable Long  id) {
		model.addAttribute("user",p);
		List<Image> all=img.findAll();
		model.addAttribute("all", all);
		
		return "gallery";
	}
	
	@RequestMapping (value="/tampil",method = RequestMethod.GET)
	public String produkku (Model model,Principal p) {
		model.addAttribute("user",p);
		return findPaginated(1, model);	
	}
	
	
	
	
	//CRUD IMAGE___________________________________________________________________
		@RequestMapping (value="/create", method = RequestMethod.GET)
		public String tambah_image(Model model)  {
			model.addAttribute("image",new Image());
			
			List<Rasa> lrasa=rs.findAll();
			model.addAttribute("rasa", lrasa);
			return "Image_Create";
			
		}
		
		
		@RequestMapping (value="/create", method = RequestMethod.POST)
		public String save(Image image, @RequestParam("pfile") MultipartFile file)
		{
			imageService.saveImage(image,file);
			return "redirect:/image/tampil";
		}
		
		@RequestMapping (value="/edit/{id}", method = RequestMethod.GET)
		public String edit_image(Model model, @PathVariable Long  id) {
			Image image= img.findById(id).get();
			model.addAttribute("image",image);

			List<Rasa> lrasa=rs.findAll();
			model.addAttribute("rasa", lrasa);
			return "Image_Create";
		}
		
		@RequestMapping (value="/delete/{id}", method = RequestMethod.GET)
		public String delete_image(@PathVariable Long id) {
			img.deleteById(id);
			return "redirect:/image/tampil";
		}


	
	
	
	
	
	
	
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value="pageNo") int pageNo, Model model) {
		int pageSize = 5;
		
		List<Image> limage=img.findAll();
		model.addAttribute("image",limage);
		
	    Page<Image> page = imageService.findPaginated(pageNo, pageSize);
	    List<Image> listProduk = page.getContent();
	    
	    model.addAttribute("currentPage",pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    model.addAttribute("listProduk", listProduk);
	    
	    
	    return "image";
	}
	
	
// GET IMAGE SESUAI RASA
	@RequestMapping (value="/get/{1}", method = RequestMethod.GET)
	public String edit_image(Model model) {
//		Image image= img.findById(id).get();
//		model.addAttribute("image",image);

		List<Rasa> lrasa=rs.findAll();
		model.addAttribute("rasa", lrasa);
		return "Image_Create";
	}

}
