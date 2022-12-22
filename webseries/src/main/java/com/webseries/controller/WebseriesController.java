package com.webseries.controller;

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

import com.webseries.model.Webseriesmodel;
import com.webseries.repo.Webseriesrepo;


@CrossOrigin
@RestController
public class WebseriesController {
	@Autowired
	private Webseriesrepo wrepo;
	@PostMapping("/addSeries")  
    private void saveseries(@RequestBody Webseriesmodel l)    
    {  
	
		wrepo.save(l);
		
    }
	@PutMapping("/update")  
    private void editseries(@RequestBody Webseriesmodel l)    
    {  
	
		wrepo.save(l);
		
    }
	@DeleteMapping("/delete")  
    private String deleteseries(@RequestBody Webseriesmodel l)    
    {  
	
		wrepo.deleteById(l.getId());
		return "Series Removed!"+l.getId();
    }
	   @GetMapping("/series")
	    public List<Webseriesmodel> serieslist(){
		   List<Webseriesmodel> series = new ArrayList<Webseriesmodel>();  
	    	wrepo.findAll().forEach(s -> series.add(s));  
	    	return series;
	    }
	   
	   @GetMapping("/series/id")
	    public List<Webseriesmodel> eachseriesbyid(@RequestBody Webseriesmodel l){
		   List<Webseriesmodel> series = new ArrayList<Webseriesmodel>();  
	    	for(var y:wrepo.findAll())
	    	{
	    		if(y.getId()==l.getId())
	    		{
	    			series.add(y);
	    		}
	    	}
	    	return series;
	    }
	   @GetMapping("/series/name")
	    public List<Webseriesmodel> eachbooklist(@RequestBody Webseriesmodel l){
		   List<Webseriesmodel> series = new ArrayList<Webseriesmodel>();  
	    	for(var y:wrepo.findAll())
	    	{
	    		if(y.getName().equals(l.getName()))
	    		{
	    			series.add(y);
	    		}
	    	}
	    	return series;
	    }
	
	
}
