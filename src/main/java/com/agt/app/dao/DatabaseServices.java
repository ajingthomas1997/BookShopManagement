package com.agt.app.dao;

import java.util.List;

import com.agt.app.pojos.User;
import com.agt.app.pojos.UserFiles;
import com.agt.app.pojos.Book;
import com.agt.app.pojos.Cart;
import com.agt.app.pojos.Order;

public interface DatabaseServices {

	// Admin Operations..
	public List<User> getAllAdmins();

	public User getAdminById(int id);

	public int insertAdmin(User user);

	public int updateAdmin(User user);

	public int deleteAdmin(User user);

	// User Operations..
	public List<User> getAllUsers();

	public User getUserById(int id);

	public int insertUser(User User);

	public int updateUser(User User);

	public int deleteUser(User User);


	// Common
	public User getUserByEmail(String email);
	
	public User getUserOrAdminById(int id);

	// Book Operations..
	public List<Book> getAllBooks();

	public List<Book> getBookByCategory(String category);
	
	public List<Book> getBooksUsingLimit(int limit, int offset);

	public Book getBookById(int id);

	public int insertBook(Book book);

	public int updateBook(Book book);

	public int updateBookQuantityById(int id, int quqntity);

	public int deleteBookbyId(int id);
	
	//Order Operations..	
	public List<Order> getAllOrders();

	public List<Order> getOrdersByUserId(int id);

//	public List<Order> getOrdersByDate(String date);

	public Order getOrderById(int id);

	public int insertOrder(Order order);

	public int deleteOrder(Order order);

	//Profile Picture
	public UserFiles getProfilePicture(int userId);
	
	public int insertProfilePicture(UserFiles userFiles);

	public int updateProfilePicture(UserFiles userFiles);

	public int deleteProfilePicture(int fileId);
	
	//User Files
	public UserFiles getUserFileByFileId(int fileID);
	
	public List<UserFiles> getAllUserFilesByUserId(int userId);
	
	public UserFiles getUserFileByUserIdAndFilePath(int userId, String filePath);
	
	public int insertUserFile(UserFiles userFiles);

	public int updateUserFile(UserFiles userFiles);

	public int deleteUserFile(int fileId);

	//cart operations
	public List<Cart> getCartItems(int userId);

	public int updateCartItem(Cart cart);

	public int insertCartItem(Cart cart);

	public int deleteCartItem(int userId, int bookId);

	public int deleteAllCartItemsByUserId(int userId);

	
}
