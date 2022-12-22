package com.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Library;
import com.library.repo.Libraryrepo;


@CrossOrigin
@RestController
public class LibraryController {
	@Autowired
	private Libraryrepo lrepo;
	@PostMapping("/saveBook")  
    private void savebook(@RequestBody Library l)    
    {  
	
		lrepo.save(l);
		
    }
	@PostMapping("/editBook")  
    private void editbook(@RequestBody Library l)    
    {  
	
		lrepo.save(l);
		
    }
	@PostMapping("/deleteBook")  
    private String deletebook(@RequestBody Library l)    
    {  
	
		lrepo.deleteById(l.getBoookid());
		return "Deleted Successfully";
    }
	   @GetMapping("/getBooks")
	    public List<Library> booklist(){
		   List<Library> books = new ArrayList<Library>();  
	    	lrepo.findAll().forEach(books1 -> books.add(books1));  
	    	return books;
	    }
	   
	   @PostMapping("/getByType")
	    public List<Library> eachbooklist(@RequestBody Library l){
		   List<Library> books = new ArrayList<Library>();  
	    	for(var y:lrepo.findAll())
	    	{
	    		if(y.getGenre().equals(l.getGenre()))
	    		{
	    			books.add(y);
	    		}
	    	}
	    	return books;
	    }
	
	
}
