package com.customerlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customerlog.repo.Logmodelrepo;
import com.customerlog.model.LogModel;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;  
@CrossOrigin
@RestController
public class LogmodelController {
	@Autowired
	private Logmodelrepo lrepo;
	@GetMapping("/checkin")  
    private void savecust(@RequestBody LogModel l)    
    {  
	
    	String[] y=l.getId().split("\\+");
    	l.setName(y[0]);
		lrepo.save(l);
		
    }
	
	@GetMapping("/checkout")  
    private void checkout(@RequestBody LogModel l)    
    {  
	
    	
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   String[] datetime=dtf.format(now).split(" ");
		   l.setDate(datetime[0]);
		   l.setTime(datetime[1]);
		   l.setIds(l.getName()+"+"+datetime[1]);
		   l.setLogType("OUT");
		   lrepo.save(l);
		
    }
	 @GetMapping("/getAllLog")
	    public List<LogModel> loglist(){
		 List<LogModel> log = new ArrayList<LogModel>();  
	    	lrepo.findAll().forEach(l1 -> log.add(l1));  
	    	return log; 
	    }
	 
	 @GetMapping("/getLog")
	    public List<LogModel> logdata(@RequestBody LogModel l){
		 List<LogModel> log = new ArrayList<LogModel>();  
	    	for(LogModel lm:lrepo.findAll())
	    	{
	    		if(lm.getDate().equals(l.getDate()))
	    		{
	    			log.add(lm);
	    		}
	    	}
	    	return log; 
	    }
}
