package com.taskmanagement.repo;

import org.springframework.data.repository.CrudRepository;

import com.taskmanagement.model.Taskmanagementmodel;

public interface Taskmanagementrepo extends CrudRepository<Taskmanagementmodel, Integer>{

}
