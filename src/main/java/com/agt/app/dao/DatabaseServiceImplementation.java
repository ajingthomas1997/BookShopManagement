package com.agt.app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.agt.app.pojos.Book;
import com.agt.app.pojos.Cart;
import com.agt.app.pojos.Order;
import com.agt.app.pojos.User;
import com.agt.app.pojos.UserFiles;

public class DatabaseServiceImplementation implements DatabaseServices {

	MySQLQueryCustomizer queryCustomizer = new MySQLQueryCustomizer();

	JDBCConnectivity connectivity = new JDBCConnectivity();

//	Logger logger = LogManager.getLogger(); TODO: add log..

	@Override
	public List<User> getAllUsers() {

		List<User> users = new ArrayList<User>();

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("Users", null, "role = 'User'"));

			while (rs.next()) {

				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8)));

			}

			return users;

		}

		catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(rs, statement, connection);
		}

		return null;

	}

	@Override
	public List<User> getAllAdmins() {

		List<User> users = new ArrayList<User>();

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("Users", null, "role = 'Admin'"));

			while (rs.next()) {

				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8)));

			}

			return users;

		}

		catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

	@Override
	public List<Book> getAllBooks() {

		List<Book> books = new ArrayList<Book>();

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("Books", null, null));

			while (rs.next()) {

				books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7)));

			}

			return books;

		}

		catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

	public List<Book> getBooksUsingLimit(int limit, int offset) {

		List<Book> books = new ArrayList<Book>();

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQueryLimit("Books", null, null, limit, offset));

			while (rs.next()) {

				books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7)));

			}

			return books;

		}

		catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(rs, statement, connection);

		}

		return null;
	}

	@Override
	public List<Order> getAllOrders() {

		List<Order> orders = new ArrayList<Order>();

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("Orders", null, null));

			while (rs.next()) {

				orders.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5),
						rs.getString(6)));

			}

			return orders;

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

//	@Override
//	public List<Order> getOrdersByDate(String date) {
//
//		List<Order> orders = new ArrayList<Order>();
//
//		Connection connection = connectivity.getConnection();
//
//		Statement statement = null;
//
//		ResultSet rs = null;
//
//		try {
//
//			statement = connection.createStatement();
//
//			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("Orders", null, "orderDate = '" + date+"'"));
//
//			while (rs.next()) {
//
//	            orders.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
//
//			}
//
//			return orders;
//
//		}
//
//		catch (SQLException e) {
//
//			e.printStackTrace();
//
//		}
//
//		finally {
//
//			connectivity.close(rs, statement, connection);
//
//		}
//
//		return null;
//
//	}

	@Override
	public List<Order> getOrdersByUserId(int id) {

		List<Order> orders = new ArrayList<Order>();

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("Orders", null, "userId = " + id));

			while (rs.next()) {

				orders.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5),
						rs.getString(6)));

			}

			return orders;

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

	@Override
	public User getAdminById(int id) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		User user = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(
					queryCustomizer.prepareSelectQuery("Users", null, "id = " + id + " and role = 'Admin'"));

			if (rs.next()) {

				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8));

			}

			return user;

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

	@Override
	public User getUserById(int id) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		User user = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(
					queryCustomizer.prepareSelectQuery("Users", null, "id = " + id + " and role = 'User'"));

			if (rs.next()) {

				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8));

			}

			return user;

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

	@Override
	public Book getBookById(int id) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		Book book = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("Books", null, "id = " + id));

			if (rs.next()) {

				book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7));

			}

			return book;

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

	@Override
	public List<Book> getBookByCategory(String category) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		List<Book> books = new ArrayList<Book>();

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("Books", null, "category = " + category));

			if (rs.next()) {

				books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7)));

			}

			return books;

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

	@Override
	public Order getOrderById(int id) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		Order order = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("Orders", null, "orderId = " + id));

			if (rs.next()) {

				order = new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5),
						rs.getString(6));

			}

			return order;

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

	@Override
	public User getUserByEmail(String email) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		User user = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("Users", null, "email = '" + email + "'"));

			if (rs.next()) {

				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8));

			}

			return user;

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

	@Override
	public User getUserOrAdminById(int id) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		User user = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("Users", null, "id = " + id));

			if (rs.next()) {

				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8));

			}

			return user;

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(rs, statement, connection);

		}

		return null;
	}

	@Override
	public int insertAdmin(User user) {

		String[] columnsToInsert = { "name", "dob", "email", "password", "gender", "role", "contactNumber" };

		String[] valuesToInsert = { user.getName(), user.getDob() + "", user.getEmail(), user.getPassword(),
				user.getGender(), "Admin", user.getContactNumber() + "" };

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement
					.executeUpdate(queryCustomizer.prepareInsertQuery("Users", columnsToInsert, valuesToInsert));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(statement, connection);

		}

		return 0;

	}

	@Override
	public int insertUser(User user) {

		String[] columnsToInsert = { "name", "dob", "email", "password", "gender", "role", "contactNumber" };

		String[] valuesToInsert = { user.getName(), user.getDob() + "", user.getEmail(), user.getPassword(),
				user.getGender(), "User", user.getContactNumber() + "" };

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement
					.executeUpdate(queryCustomizer.prepareInsertQuery("Users", columnsToInsert, valuesToInsert));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(statement, connection);

		}

		return 0;
	}

	@Override
	public int insertBook(Book book) {

		String[] columnsToInsert = { "id", "title", "author", "category", "quantity", "price", "image" };

		String[] valuesToInsert = { book.getId() + "", book.getTitle(), book.getAuthor() + "", book.getCategory() + "",
				book.getQuantity() + "", book.getPrice() + "", book.getImage() };

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement
					.executeUpdate(queryCustomizer.prepareInsertQuery("Books", columnsToInsert, valuesToInsert));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(statement, connection);

		}

		return 0;
	}

	@Override
	public int insertOrder(Order order) {

		String[] columnsToInsert = { "userId", "bookId", "quantity", "totalPrice", "orderDate" };

		LocalDate currentDate = LocalDate.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String formattedDate = currentDate.format(formatter);

		String[] valuesToInsert = { order.getUserId() + "", order.getBookId() + "", order.getQuantity() + "",
				order.getTotalPrice() + "", formattedDate };

		System.out.println(order.getOrderDate());

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement
					.executeUpdate(queryCustomizer.prepareInsertQuery("Orders", columnsToInsert, valuesToInsert));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(statement, connection);

		}

		return 0;

	}

	@Override
	public int updateAdmin(User user) {

		String[] columnsToUpdate = { "name", "dob", "gender", "contactNumber" };

		String[] newValues = { user.getName(), user.getDob() + "", user.getGender(), user.getContactNumber() + "" };

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement.executeUpdate(
					queryCustomizer.prepareUpdateQuery("Users", columnsToUpdate, newValues, "id=" + user.getId()));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(statement, connection);

		}

		return 0;
	}

	@Override
	public int updateUser(User user) {

		String[] columnsToUpdate = { "name", "dob", "gender", "contactNumber" };

		String[] newValues = { user.getName(), user.getDob() + "", user.getGender(), user.getContactNumber() + "" };

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement.executeUpdate(
					queryCustomizer.prepareUpdateQuery("Users", columnsToUpdate, newValues, "id=" + user.getId()));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(statement, connection);

		}

		return 0;

	}

	@Override
	public int updateBook(Book book) {

		String[] columnsToUpdate = { "quantity", "price" };

		String[] newValues = { book.getQuantity() + "", book.getPrice() + "" };

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement.executeUpdate(
					queryCustomizer.prepareUpdateQuery("Books", columnsToUpdate, newValues, "id = " + book.getId()));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(statement, connection);

		}

		return 0;

	}

	@Override
	public int updateBookQuantityById(int id, int quantity) {

		String[] columnsToUpdate = { "quantity" };

		String[] newValues = { quantity + "" };

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement
					.executeUpdate(queryCustomizer.prepareUpdateQuery("Books", columnsToUpdate, newValues, "id=" + id));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(statement, connection);

		}

		return 0;

	}

	@Override
	public int deleteAdmin(User user) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement.executeUpdate(queryCustomizer.prepareDeleteQuery("Users", "id=" + user.getId()));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(statement, connection);

		}

		return 0;

	}

	@Override
	public int deleteUser(User user) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement.executeUpdate(queryCustomizer.prepareDeleteQuery("Users", "id=" + user.getId()));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(statement, connection);

		}

		return 0;

	}

	@Override
	public int deleteBookbyId(int id) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement.executeUpdate(queryCustomizer.prepareDeleteQuery("books", " id  = " + id));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(statement, connection);

		}

		return 0;
	}

	@Override
	public int deleteOrder(Order order) {
		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement.executeUpdate(
					queryCustomizer.prepareDeleteQuery("Orders", "orderId = '" + order.getOrderId() + "'"));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(statement, connection);

		}

		return 0;

	}

	@Override
	public List<UserFiles> getAllUserFilesByUserId(int userId) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		List<UserFiles> userFiles = new ArrayList<UserFiles>();

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("userfiles", null,
					"userId = " + userId + " and fileType = 'File'"));

			while (rs.next()) {

				userFiles.add(
						new UserFiles(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));

			}

			return userFiles;

		}

		catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(rs, statement, connection);

		}

		return null;
	}

	@Override
	public UserFiles getUserFileByUserIdAndFilePath(int userId, String filePath) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		UserFiles userFile = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("userfiles", null,
					"userId = " + userId + " and filePath = '" + filePath + "'"));

			while (rs.next()) {

				userFile = new UserFiles(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));

			}

			return userFile;

		}

		catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

	@Override
	public UserFiles getUserFileByFileId(int fileId) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		UserFiles userFile = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("userfiles", null, "fileId = " + fileId));

			while (rs.next()) {

				userFile = new UserFiles(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));

			}

			return userFile;

		}

		catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

	@Override
	public int insertUserFile(UserFiles userFiles) {
		String[] columnsToInsert = { "userId", "fileType", "filePath", "date" };

		String[] valuesToInsert = { userFiles.getUserId() + "", "File", userFiles.getFilePath(), userFiles.getDate() };

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement
					.executeUpdate(queryCustomizer.prepareInsertQuery("userfiles", columnsToInsert, valuesToInsert));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(statement, connection);

		}

		return 0;
	}

	@Override
	public int updateUserFile(UserFiles userFiles) {
		String[] columnsToUpdate = { "filePath" };

		String[] newValues = { userFiles.getFilePath() };

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement.executeUpdate(queryCustomizer.prepareUpdateQuery("userfiles", columnsToUpdate,
					newValues, "userid=" + userFiles.getUserId() + " and fileId= " + userFiles.getFileId()));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(statement, connection);

		}

		return 0;
	}

	@Override
	public int deleteUserFile(int fileId) {
		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement
					.executeUpdate(queryCustomizer.prepareDeleteQuery("userfiles", "fileId=" + fileId));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(statement, connection);

		}

		return 0;
	}

	@Override
	public List<Cart> getCartItems(int userId) {

		List<Cart> cart = new ArrayList<Cart>();

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("cart", null, "userId = " + userId));

			while (rs.next()) {

				cart.add(new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5)));

			}

			return cart;

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

	@Override
	public int updateCartItem(Cart cart) {

		String[] columnsToUpdate = { "quantity", "price" };

		String[] newValues = { cart.getQuantity() + "", cart.getPrice() + "" };

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement.executeUpdate(queryCustomizer.prepareUpdateQuery("cart", columnsToUpdate,
					newValues, "userId = " + cart.getUserId() + " and bookId = " + cart.getBookId()));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(statement, connection);

		}

		return 0;

	}

	@Override
	public int insertCartItem(Cart cart) {

		String[] columnsToInsert = { "userId", "bookId", "quantity", "price" };

		String[] valuesToInsert = { cart.getUserId() + "", cart.getBookId() + "", cart.getQuantity() + "",
				cart.getPrice() + "" };

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement
					.executeUpdate(queryCustomizer.prepareInsertQuery("cart", columnsToInsert, valuesToInsert));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(statement, connection);

		}

		return 0;

	}

	@Override
	public int deleteCartItem(int userId, int bookId) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement.executeUpdate(queryCustomizer.prepareDeleteQuery("cart",
					"userId = " + userId + " and bookId = '" + bookId + "'"));

			System.out.println(rowupdates);

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(statement, connection);

		}

		return 0;

	}

	@Override
	public int deleteAllCartItemsByUserId(int userId) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement
					.executeUpdate(queryCustomizer.prepareDeleteQuery("cart", " userId  = " + userId));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(statement, connection);

		}

		return 0;

	}

	@Override
	public UserFiles getProfilePicture(int userId) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		UserFiles profile = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("userfiles", null,
					"userId = " + userId + " and fileType = 'ProfilePicture'"));

			if (rs.next()) {

				profile = new UserFiles(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));

			}

			return profile;

		}

		catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(rs, statement, connection);

		}

		return null;
	}

	@Override
	public int updateProfilePicture(UserFiles userFiles) {

		String[] columnsToUpdate = { "filePath" };

		String[] newValues = { userFiles.getFilePath() };

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement.executeUpdate(queryCustomizer.prepareUpdateQuery("userfiles", columnsToUpdate,
					newValues, "userid=" + userFiles.getUserId() + " and fileType= 'ProfilePicture'"));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(statement, connection);

		}

		return 0;
	}

	@Override
	public int insertProfilePicture(UserFiles userFiles) {

		String[] columnsToInsert = { "userId", "fileType", "filePath", "date" };

		String[] valuesToInsert = { userFiles.getUserId() + "", "ProfilePicture", userFiles.getFilePath(),
				userFiles.getDate() };

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement
					.executeUpdate(queryCustomizer.prepareInsertQuery("userfiles", columnsToInsert, valuesToInsert));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(statement, connection);

		}

		return 0;
	}

	@Override
	public int deleteProfilePicture(int fileId) {
		Connection connection = connectivity.getConnection();

		Statement statement = null;

		try {

			statement = connection.createStatement();

			int rowupdates = statement
					.executeUpdate(queryCustomizer.prepareDeleteQuery("userfiles", "fileId=" + fileId));

			return rowupdates;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectivity.close(statement, connection);

		}

		return 0;
	}

	public Cart getCartItemByUserIdAndBookId(int userId, int bookId) {

		Connection connection = connectivity.getConnection();

		Statement statement = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(
					queryCustomizer.prepareSelectQuery("cart", null, "userId = " + userId + " and bookId = " + bookId));

			if (rs.next()) {

				return new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5));

			}

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(rs, statement, connection);

		}

		return null;
	}

	public Cart getCartItemByCartId(int cartId) {
		Connection connection = connectivity.getConnection();

		Statement statement = null;

		ResultSet rs = null;

		try {

			statement = connection.createStatement();

			rs = statement.executeQuery(queryCustomizer.prepareSelectQuery("cart", null, "cartId = " + cartId));

			if (rs.next()) {

				return new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5));

			}

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

		finally {

			connectivity.close(rs, statement, connection);

		}

		return null;

	}

}