package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {

	@Autowired
    private ProductRepository repo;
	
	//Retrive all product Items
	public List<Product> getAllProdList()
    {
        List<Product> proList = repo.findAll();
         
        if(proList.size() > 0) {
            return proList;
        } else {
            return new ArrayList<Product>();
        }
    }
    
	//Rertive product by Pro Id data
    public Product getProductById(int id) throws ProductOutOfStockException
    {
        Optional<Product> pro = repo.findById(id);
         
        if(pro.isPresent()) {
            return pro.get();
        } else {
            throw new ProductOutOfStockException("Product is out Of Stock !");
        }
    }
     
    public void deleteProdById(int id) throws ProductOutOfStockException
    {
        Optional<Product> pro = repo.findById(id);
         
        if(pro.isPresent())
        {
        	repo.deleteById(id);
        } else {
            throw new ProductOutOfStockException("Unable to fetch Product deails");
        }
    }
    
    
    public Product updateProdItem(Product pro) {
    	Optional<Product> prod = repo.findById(pro.getId());
        
        if(prod.isPresent())
        {
        	Product newPro = prod.get();
        	newPro.setName(pro.getName());
        	newPro.setPrice(pro.getPrice());
        	newPro = repo.save(newPro);
             
            return newPro;
        } else {
            pro = repo.save(pro);            
            return pro;
        }
    } 
	
}
