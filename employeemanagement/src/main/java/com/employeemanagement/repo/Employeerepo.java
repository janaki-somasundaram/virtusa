package com.employeemanagement.repo;

import org.springframework.data.repository.CrudRepository;

import com.employeemanagement.model.Employee;

public interface Employeerepo extends CrudRepository<Employee, Integer>{

}
