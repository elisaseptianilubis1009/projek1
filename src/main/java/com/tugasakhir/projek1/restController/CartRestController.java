package com.tugasakhir.projek1.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tugasakhir.projek1.model.Cart;
import com.tugasakhir.projek1.service.CartService;



@RestController
@RequestMapping(value= "api/cart")
public class CartRestController {
	
	@Autowired
	private CartService cr;
	
	
	@RequestMapping (value = "find/{id}" , method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity <Cart> find(@PathVariable("id") Long id){
		
		try {
			return new ResponseEntity<Cart>(cr.find(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Cart>(HttpStatus.BAD_REQUEST);
		}
		
		
	}

}
