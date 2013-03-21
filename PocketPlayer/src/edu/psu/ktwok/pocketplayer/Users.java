package edu.psu.ktwok.pocketplayer;

public class Users {
	String _name;
	String _email;
	String _password;
	
	// Empty Constructor
	public Users() {}
	
	// Constructor for Registration
	public Users(String name, String email, String password) {
		this._name = name;
		this._email = email;
		this._password = password;
	}
	
	// Constructor for Login
	public Users(String email, String password) {
		this._email = email;
		this._password = password;
	}
	
	// Get Name
	public String getName() {
		return this._name;
	}
	
	// Set Name
	public void setName(String name) {
		this._name = name;
	}
	
	// Get Email
	public String getEmail() {
		return this._email;
	}
	
	// Set Email
	public void setEmail(String email) {
		this._email = email;
	}
	
	// Get Password
	public String getPassword() {
		return this._password;
	}
	
	// Set Password
	public void sestPassword(String password) {
		this._password = password;
	}
}
