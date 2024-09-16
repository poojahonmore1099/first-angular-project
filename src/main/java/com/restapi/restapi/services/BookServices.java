package com.restapi.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.restapi.restapi.dao.BooksRepo;
import com.restapi.restapi.models.Books;

@Service
public class BookServices {

	@Autowired
	private BooksRepo bookRepo;
	
	public List<Books> getAllBooks()
	{
		List<Books> list=(List<Books>)bookRepo.findAll();
		return list;
	}
	
	
	public Books findById(int id)
	{
		Books book = null;
		try {
			
			book=bookRepo.findById(id);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return book;
	}
	
	
	public Books addBook(Books book)
	{
		Books result=bookRepo.save(book);
		return result;
	}
	
	public void deleteBook(int bid)
	{
		bookRepo.deleteById(bid);
	}
	
	public void updateBook(Books book,int id)
	{
		book.setId(id);
		bookRepo.save(book);
	}
}
