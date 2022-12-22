package com.taskmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.model.Taskmanagementmodel;
import com.taskmanagement.repo.Taskmanagementrepo;


@CrossOrigin
@RestController
public class WebseriesController {
	@Autowired
	private Taskmanagementrepo taskrepo;
	@PostMapping("/saveTask")  
    private void saveTask(@RequestBody Taskmanagementmodel l)    
    {  
	
		taskrepo.save(l);
		
    }
	@GetMapping("/changeStatus")  
    private void changeStatus(@RequestBody Taskmanagementmodel l)    
    {  
	
		taskrepo.save(l);
		
    }
	@GetMapping("/deleteHouse")  
    private String deleteseries(@RequestBody Taskmanagementmodel l)    
    {  
	
		taskrepo.deleteById(l.getTaskId());
		return "Task Removed!";
    }
	   @GetMapping("/alltasks")
	    public List<Taskmanagementmodel> Alltask(){
		   List<Taskmanagementmodel> tasks = new ArrayList<Taskmanagementmodel>();  
	    	taskrepo.findAll().forEach(t -> tasks.add(t));  
	    	return tasks;
	    }
	   
	   @GetMapping("/getTask")
	    public List<Taskmanagementmodel> gettaskbyid(@RequestBody Taskmanagementmodel l){
		   List<Taskmanagementmodel> tasks = new ArrayList<Taskmanagementmodel>();  
	    	for(var t:taskrepo.findAll())
	    	{
	    		if(t.getTaskName().equals(l.getTaskName()))
	    		{
	    			tasks.add(t);
	    		}
	    	}
	    	return tasks;
	    }
	   
	
}
