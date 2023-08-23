package com.agt.app.pojos;

public class User {

	private int id;

	private String name;

	private String dob;

	private String email;

	private String password;

	private String gender;

	private String role;

	private long contactNumber;

	public User() {

	}

	public User(String name, String dob, String email, String password, String gender, String role,
			long contactNumber) {

		this.name = name;

		this.dob = dob;

		this.email = email;

		this.password = password;

		this.gender = gender;

		this.role = role;

		this.contactNumber = contactNumber;

	}

	public User(int id, String name, String dob, String email, String password, String gender, String role,
			long contactNumber) {

		this.id = id;

		this.name = name;

		this.dob = dob;

		this.email = email;

		this.password = password;

		this.gender = gender;

		this.role = role;

		this.contactNumber = contactNumber;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + '\'' + ", dob='" + dob + '\'' + ", email='" + email + '\''
				+ ", password='" + password + '\'' + ", gender='" + gender + '\'' + ", role='" + role + '\''
				+ ", contactNumber=" + contactNumber + '}';
	}
}
