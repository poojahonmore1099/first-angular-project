package com.restapi.restapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.restapi.models.Books;
import com.restapi.restapi.services.BookServices;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
		
	@Autowired
	private BookServices bookServies;
	
	 	@GetMapping("/books")
	    public ResponseEntity<List<Books>> getBooks() {
	 		
	 		List<Books> list=bookServies.getAllBooks();
	 		if(list.size()<=0)
	 		{
	 			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	 		}
	        return ResponseEntity.status(HttpStatus.CREATED).body(list);
	    }
	 	
	 	@GetMapping("/books/{id}")
	 	public ResponseEntity<Books> getBook(@PathVariable("id") int id) {
			Books book=bookServies.findById(id);
			if(book==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
	        return ResponseEntity.of(Optional.of(book));
		}
	 	
	 	
	 	@PostMapping("/books")
	 	public ResponseEntity<Books> addBook(@RequestBody Books book) {
	 		Books b=null;
	 		
			try {
				b=bookServies.addBook(book);
				System.out.println(ResponseEntity.status(HttpStatus.CREATED).build());
				return ResponseEntity.status(HttpStatus.CREATED).build();

			}catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

			}
			
		}
	 	
	 	@DeleteMapping("books/{id}")
	 	public  ResponseEntity<Books> deleteBook(@PathVariable("id") int id) {
	 		try {
				bookServies.deleteBook(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

			}catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

			}
	 	}
	 	
	 	
	 	
	 	
}
