package com.agt.app.service.implementations;

import java.util.List;

import com.agt.app.dao.DatabaseServiceImplementation;
import com.agt.app.pojos.Book;
import com.agt.app.service.interfaces.BookService;

public class BookServiceImplementation extends OrderServiceImplementation implements BookService {
	
	DatabaseServiceImplementation databaseServiceImplementation = new DatabaseServiceImplementation();

	protected BookServiceImplementation() {

	}
	
	@Override
	public boolean addBook(Book book) {

		return databaseServiceImplementation.insertBook(book)>0;
	}

	@Override
	public boolean updateBook(Book book) {

		return databaseServiceImplementation.updateBook(book)>0;
	}

	@Override
	public List<Book> getAllBooks() {

		return databaseServiceImplementation.getAllBooks();
	}

	@Override
	public List<Book> getBooksByCategory(String category) {

		return databaseServiceImplementation.getBookByCategory(category);
	}

	@Override
	public Book getBookById(int id) {

		return databaseServiceImplementation.getBookById(id);
	}

	@Override
	public boolean updateBookQuantityById(int id, int quantity) {

		return databaseServiceImplementation.updateBookQuantityById(id,quantity)>0;
	}
	
	@Override
	public List<Book> getBooksUsingLimit(int limit, int offset){
		
		return databaseServiceImplementation.getBooksUsingLimit(limit, offset);
		
	}

	@Override
	public boolean deleteBookById(int id) {

		return databaseServiceImplementation.deleteBookbyId(id)>0;
	}

}
