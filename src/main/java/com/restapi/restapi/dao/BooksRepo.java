package com.restapi.restapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.models.Books;

@Repository
public interface BooksRepo extends CrudRepository<Books, Integer> {
	public Books findById(int id);
}
