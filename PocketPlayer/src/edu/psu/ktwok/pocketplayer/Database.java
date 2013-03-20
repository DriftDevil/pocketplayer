package edu.psu.ktwok.pocketplayer;

public class Database {
	String _name;
	String _email;
	String _password;
	
	// Empty Constructor
	public Database() {}
	
	// Constructor for Registration
	public Database(String name, String email, String password) {
		this._name = name;
		this._email = email;
		this._password = password;
	}
	
	// Constructor for Login
	public Database(String email, String password) {
		this._email = email;
		this._password = password;
	}
}
