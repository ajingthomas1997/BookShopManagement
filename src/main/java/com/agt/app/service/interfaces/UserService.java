package com.agt.app.service.interfaces;

import java.util.List;

import com.agt.app.pojos.User;
import com.agt.app.pojos.UserFiles;

public interface UserService {

	// Admin Operations..
	public List<User> getAllAdmins();

	public boolean addAdmin(User user);

	public boolean updateAdmin(User user);

	public boolean deleteAdmin(User user);

	public User getAdminById(int id);

	// User Operations..
	public List<User> getAllUsers();

	public User getUserById(int id);

	public boolean addUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(User user);

	// common
	public User getUserByEmail(String email);

	public User getUserOrAdminById(int id);

	// Profile Picture
	public UserFiles getProfilePicture(int userId);

	public boolean insertProfilePicture(UserFiles userFiles);

	public boolean updateProfilePicture(UserFiles userFiles);

	public boolean deleteProfilePicture(int fileId);

	// User Files
	public List<UserFiles> getAllUserFilesByUserId(int userId);

	public UserFiles getUserFileByUserIdAndFilePath(int userId, String filePath);

	public boolean insertUserFile(UserFiles userFiles);

	public boolean updateUserFile(UserFiles userFiles);

	public boolean deleteUserFile(int fileId);

}