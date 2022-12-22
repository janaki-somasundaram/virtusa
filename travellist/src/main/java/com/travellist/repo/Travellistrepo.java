package com.travellist.repo;

import org.springframework.data.repository.CrudRepository;

import com.travellist.model.Travellist;

public interface Travellistrepo extends CrudRepository<Travellist, Integer>{

}
