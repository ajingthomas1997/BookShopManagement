package com.agt.app.service.implementations;

import java.util.List;

import com.agt.app.dao.DatabaseServiceImplementation;
import com.agt.app.pojos.User;
import com.agt.app.pojos.UserFiles;
import com.agt.app.service.interfaces.UserService;

public class UserServiceImplementation extends BookServiceImplementation implements UserService {

	DatabaseServiceImplementation databaseServiceImplementation = new DatabaseServiceImplementation();

	protected UserServiceImplementation() {

	}

	@Override
	public boolean addAdmin(User user) {

		return databaseServiceImplementation.insertAdmin(user)>0;
	}

	@Override
	public List<User> getAllAdmins() {

		return databaseServiceImplementation.getAllAdmins();
	}

	@Override
	public boolean updateAdmin(User user) {

		return databaseServiceImplementation.updateAdmin(user)>0;
	}

	@Override
	public boolean deleteAdmin(User user) {

		return databaseServiceImplementation.deleteAdmin(user)>0;
	}

	@Override
	public User getAdminById(int id) {

		return databaseServiceImplementation.getAdminById(id);
	}
	
	@Override
	public User getUserOrAdminById(int id) {

		return databaseServiceImplementation.getUserOrAdminById(id);
	}

	@Override
	public boolean addUser(User user) {

		return databaseServiceImplementation.insertUser(user)>0;
	}

	@Override
	public List<User> getAllUsers() {

		return databaseServiceImplementation.getAllUsers();
	}

	@Override
	public boolean updateUser(User user) {

		return databaseServiceImplementation.updateUser(user)>0;
	}

	@Override
	public boolean deleteUser(User user) {

		return databaseServiceImplementation.deleteUser(user)>0;
	}

	@Override
	public User getUserById(int id) {

		return databaseServiceImplementation.getUserById(id);
	}

	@Override
	public User getUserByEmail(String email) {

		return databaseServiceImplementation.getUserByEmail(email);
	}

	@Override
	public UserFiles getProfilePicture(int userId) {

		return databaseServiceImplementation.getProfilePicture(userId);
	}

	@Override
	public boolean insertProfilePicture(UserFiles userFiles) {

		return databaseServiceImplementation.insertProfilePicture(userFiles)>0;
	}

	@Override
	public boolean updateProfilePicture(UserFiles userFiles) {

		return databaseServiceImplementation.updateProfilePicture(userFiles)>0;
	}

	@Override
	public boolean deleteProfilePicture(int fileId) {

		return databaseServiceImplementation.deleteProfilePicture(fileId)>0;
	}

	@Override
	public List<UserFiles> getAllUserFilesByUserId(int userId) {

		return databaseServiceImplementation.getAllUserFilesByUserId(userId);
	}

	@Override
	public boolean insertUserFile(UserFiles userFiles) {

		return databaseServiceImplementation.insertUserFile(userFiles)>0;
	}

	@Override
	public boolean updateUserFile(UserFiles userFiles) {

		return databaseServiceImplementation.updateUserFile(userFiles)>0;
	}

	@Override
	public boolean deleteUserFile(int fileId) {

		return databaseServiceImplementation.deleteUserFile(fileId)>0;
	}

	@Override
	public UserFiles getUserFileByUserIdAndFilePath(int userId, String filePath) {

		return databaseServiceImplementation.getUserFileByUserIdAndFilePath(userId, filePath);
	}

	public UserFiles getAllUserFilesByFileId(int id) {

		return databaseServiceImplementation.getUserFileByFileId(id);
	}

}