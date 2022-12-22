package com.carrental.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.model.Carrentalmodel;
import com.carrental.repo.Carrentalrepo;


@CrossOrigin
@RestController
public class CarrentalController {
	@Autowired
	private Carrentalrepo carrepo;
	@PostMapping("/saveCar")  
    private void saveCar(@RequestBody Carrentalmodel l)    
    {  
	
		carrepo.save(l);
		
    }
	@PostMapping("/editCar")  
    private void editCar(@RequestBody Carrentalmodel l)    
    {  
	
		carrepo.save(l);
		
    }
	@GetMapping("/deleteCar")  
    private String deleteCar(@RequestBody Carrentalmodel l)    
    {  
	
		carrepo.deleteById(l.getCarId());
		return "Car deleted successfully";
    }
	   @GetMapping("/getCars")
	    public List<Carrentalmodel> Allcar(){
		   List<Carrentalmodel> Cars = new ArrayList<Carrentalmodel>();  
	    	carrepo.findAll().forEach(t -> Cars.add(t));  
	    	return Cars;
	    }
	   
	   @GetMapping("/getCar")
	    public List<Carrentalmodel> getcarbyid(@RequestBody Carrentalmodel l){
		   List<Carrentalmodel> cars = new ArrayList<Carrentalmodel>();  
	    	for(var t:carrepo.findAll())
	    	{
	    		if(t.getCarId()==l.getCarId())
	    		{
	    			cars.add(t);
	    		}
	    	}
	    	return cars;
	    }
	   
	
}
