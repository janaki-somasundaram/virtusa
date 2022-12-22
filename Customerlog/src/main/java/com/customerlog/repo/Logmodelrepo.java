package com.customerlog.repo;

import org.springframework.data.repository.CrudRepository;

import com.customerlog.model.LogModel;

public interface Logmodelrepo extends CrudRepository<LogModel, String>{

}
