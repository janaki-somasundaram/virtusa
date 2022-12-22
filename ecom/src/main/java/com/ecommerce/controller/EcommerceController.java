package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Ecommercemodel;
import com.ecommerce.repo.Ecommercerepo;


@CrossOrigin
@RestController
public class EcommerceController {
	@Autowired
	private Ecommercerepo ecomrepo;
	@PostMapping("/saveProduct")  
    private void saveProduct(@RequestBody Ecommercemodel l)    
    {  
	
		ecomrepo.save(l);
		
    }
	
	@GetMapping("/deleteProduct")  
    private String deleteProduct(@RequestBody Ecommercemodel l)    
    {  
	
		ecomrepo.deleteById(l.getProductId());
		return "Product deleted successfully";
    }
	   @GetMapping("/getallProduct")
	    public List<Ecommercemodel> Allproduct(){
		   List<Ecommercemodel> Products = new ArrayList<Ecommercemodel>();  
		   ecomrepo.findAll().forEach(t -> Products.add(t));  
	    	return Products;
	    }
	   
	   @GetMapping("/getByType")
	    public List<Ecommercemodel> getproductbytype(@RequestBody Ecommercemodel l){
		   List<Ecommercemodel> Products = new ArrayList<Ecommercemodel>();  
	    	for(var t:ecomrepo.findAll())
	    	{
	    		if(t.getType().equals(l.getType()))
	    		{
	    			Products.add(t);
	    		}
	    	}
	    	return Products;
	    }
	   @GetMapping("/getProduct")
	    public List<Ecommercemodel> getproductbyid(@RequestBody Ecommercemodel l){
		   List<Ecommercemodel> Products = new ArrayList<Ecommercemodel>();  
	    	for(var t:ecomrepo.findAll())
	    	{
	    		if(t.getProductId()==l.getProductId())
	    		{
	    			Products.add(t);
	    		}
	    	}
	    	return Products;
	    }
	   
	
}
