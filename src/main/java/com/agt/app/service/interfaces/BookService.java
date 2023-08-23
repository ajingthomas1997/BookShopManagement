package com.agt.app.service.interfaces;

import java.util.List;

import com.agt.app.pojos.Book;

public interface BookService {

	public List<Book> getAllBooks();
	
	public List<Book> getBooksByCategory(String category);

	public Book getBookById(int id);
	
	public boolean addBook(Book book);
	
	public boolean updateBook(Book book);
	
	public boolean updateBookQuantityById(int id, int quantity);

	public boolean deleteBookById(int id);

	public List<Book> getBooksUsingLimit(int limit, int offset);
	
	
}
