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
import com.tugasakhir.projek1.model.Produk;
import com.tugasakhir.projek1.model.Rasa;
import com.tugasakhir.projek1.model.Ukuran;
import com.tugasakhir.projek1.repository.ProdukRepository;
import com.tugasakhir.projek1.repository.RasaRepository;
import com.tugasakhir.projek1.repository.UkuranRepository;
import com.tugasakhir.projek1.service.ProdukService;

@Controller
@RequestMapping("/produk")
public class ProdukController {
	@Autowired
	ProdukRepository pr;
	@Autowired
	RasaRepository rs;
	@Autowired
	UkuranRepository uk;
	@Autowired
	ProdukService ps; 
	
	
	@RequestMapping (value="/tampil",method = RequestMethod.GET)
	public String produk (Model model,Principal p) {
		model.addAttribute("user",p);
		return findPaginated(1, model);	
	}
	
	
	//CRUD PRODUK___________________________________________________________________
	@RequestMapping (value="/create", method = RequestMethod.GET)
	public String tambahProduk(Model model,Principal p)  {
		model.addAttribute("produk",new Produk());
		model.addAttribute("user",p);
		
		List<Rasa> lrasa=rs.findAll();
		model.addAttribute("rasa", lrasa);
		
		List<Ukuran> lukuran=uk.findAll();
		model.addAttribute("ukuran", lukuran);
		return "Produk_Create";
	}
 
	@RequestMapping (value="/save", method = RequestMethod.POST)
	public String save(Produk produk, @RequestParam("pfile") MultipartFile file )
	{
		ps.saveProduct(produk,file);
		return "redirect:/produk/tampil";
	}


	@RequestMapping (value="/edit/{produk}", method = RequestMethod.GET)
	public String edit_pr(Model model, Produk produk,Principal p){
		model.addAttribute("user",p);

		List<Rasa> lrasa=rs.findAll();
		model.addAttribute("rasa", lrasa);
		
		List<Ukuran> lukuran=uk.findAll();
		model.addAttribute("ukuran", lukuran);
		return "Produk_Create";
	}
	
	
	@RequestMapping (value="/delete/{id}", method = RequestMethod.GET)
	public String delete_mhs(@PathVariable Long id) {
		pr.deleteById(id);
		return "redirect:/produk/tampil";
	}

	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value="pageNo") int pageNo, Model model) {
		int pageSize = 5;
	
		List<Produk> lproduk=pr.findAll();
		model.addAttribute("produk",lproduk);
		
	    Page<Produk> page = ps.findPaginated(pageNo, pageSize);
	    List<Produk> listProduk = page.getContent();
	    
	    model.addAttribute("currentPage",pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    model.addAttribute("listProduk", listProduk);
	    
	    
	    return "produk";
	}
	


}
