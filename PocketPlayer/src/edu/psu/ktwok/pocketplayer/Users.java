package edu.psu.ktwok.pocketplayer;

public class Users {
	int _gid;
	String _user;
	String _email;
	String _password;
	
	// Empty Constructor
	public Users() {}
	
	// Constructor for Registration
	public Users(int gid, String user, String email, String password) {
		this._gid = gid;
		this._user = user;
		this._email = email;
		this._password = password;
	}
	
	// Constructor for Login
	public Users(String email, String password) {
		this._email = email;
		this._password = password;
	}
	
	// Constructor for Contacts
	public Users(int gid, String user, String email) {
		this._gid = gid;
		this._user = user;
		this._email = email;
	}
	
	// Get ID
	public int getId() {
		return this._gid;
	}
	
	// Set ID
	public void setId(int gid) {
		this._gid = gid;
	}
	
	// Get Name
	public String getName() {
		return this._user;
	}
	
	// Set Name
	public void setName(String user) {
		this._user = user;
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
	public void setPassword(String password) {
		this._password = password;
	}
}
