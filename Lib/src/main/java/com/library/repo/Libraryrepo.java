package com.library.repo;

import org.springframework.data.repository.CrudRepository;

import com.library.model.Library;

public interface Libraryrepo extends CrudRepository<Library, Integer>{

}
