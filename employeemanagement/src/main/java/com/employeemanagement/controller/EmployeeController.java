package com.employeemanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.model.Employee;
import com.employeemanagement.repo.Employeerepo;


@CrossOrigin
@RestController
public class EmployeeController {
	@Autowired
	private Employeerepo emorepo;
	@PostMapping("/addEmployee")  
    private void addEmployee(@RequestBody Employee l)    
    {  
	
		emorepo.save(l);
		
    }
	
	@GetMapping("/deleteEmployee")  
    private String deleteEmployee(@RequestBody Employee l)    
    {  
	
		emorepo.deleteById(l.getEmployeeid());
		return "Employee deleted successfully";
    }
	   @GetMapping("/getallEmployee")
	    public List<Employee> getallEmployee(){
		   List<Employee> Employees = new ArrayList<Employee>();  
		   emorepo.findAll().forEach(t -> Employees.add(t));  
	    	return Employees;
	    }
	   
	   @GetMapping("/getEmployee")
	    public List<Employee> getEmployee(@RequestBody Employee l){
		   List<Employee> Employees = new ArrayList<Employee>();  
	    	for(var t:emorepo.findAll())
	    	{
	    		if(t.getEmployeeid()==l.getEmployeeid())
	    		{
	    			Employees.add(t);
	    		}
	    	}
	    	return Employees;
	    }
	   
	
}
