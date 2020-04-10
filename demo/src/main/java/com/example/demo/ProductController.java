package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	
	@Autowired
    private ProductServices service;
	
	@GetMapping
    public ResponseEntity<List<Product>> getAllProdData() {
        List<Product> list = service.getAllProdList();
 
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Product> getEmployeeById(@PathVariable("id") int id)
                                                    throws ProductOutOfStockException {
		Product pro = service.getProductById(id);
 
        return new ResponseEntity<Product>(pro, new HttpHeaders(), HttpStatus.OK);
    }
	
    @PostMapping
    public ResponseEntity<Product> UpdateProdDate(Product pro)
                                                    throws ProductOutOfStockException {
    	Product objPro = service.updateProdItem(pro);
        return new ResponseEntity<Product>(objPro, new HttpHeaders(), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public HttpStatus deleteProdDataById(@PathVariable("id") int id)
                                                    throws ProductOutOfStockException {
        service.deleteProdById(id);
        return HttpStatus.FORBIDDEN;
    }
 
	
}
