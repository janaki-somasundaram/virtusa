package com.travellist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travellist.model.Travellist;
import com.travellist.repo.Travellistrepo;


@CrossOrigin
@RestController
public class TravellistController {
	@Autowired
	private Travellistrepo travelrepo;
	@PostMapping("/addTravel")  
    private String addTravel(@RequestBody Travellist l)    
    {  
	
		travelrepo.save(l);
		return "Travel added successfully";
		
    }
	
	@PutMapping("/travel")  
    private String Travel(@RequestBody Travellist l)    
    {  
	
		travelrepo.save(l);
		return "Travel updated successfully";
    }
	
	@DeleteMapping("/travel")  
    private String deleteEmployee(@RequestBody Travellist l)    
    {  
	
		travelrepo.deleteById(l.getId());
		return "Travel deleted successfully";
    }
	   @GetMapping("/gettravel")
	    public List<Travellist> gettravel(){
		   List<Travellist> Travellists = new ArrayList<Travellist>();  
		   travelrepo.findAll().forEach(t -> Travellists.add(t));  
	    	return Travellists;
	    }
	   
	   @GetMapping("/travel")
	    public List<Travellist> gettravelbyid(@RequestBody Travellist l){
		   List<Travellist> Employees = new ArrayList<Travellist>();  
	    	for(var t:travelrepo.findAll())
	    	{
	    		if(t.getId()==l.getId())
	    		{
	    			Employees.add(t);
	    		}
	    	}
	    	return Employees;
	    }
	   
	
}
