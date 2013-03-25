package edu.psu.ktwok.pocketplayer;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	// Database Version Number
	private static final int DATABASE_VERSION = 0;
	// Database Name
	private static final String DATABASE_NAME = "usersManager";
	// Login Table Name
	private static final String TABLE_LOGIN = "login";
	// Registration Table Name
	private static final String TABLE_REGISTRATION = "registration";
	// Contacts Table Name
	private static final String TABLE_CONTACTS = "contacts";
	
	// Table Columns names
	private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    
    public DatabaseHandler(Context context) {
    	super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    // Create Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
    	
    	// Creating the Registration Table
    	String CREATE_REGISTRATION_TABLE = "CREATE TABLE " + TABLE_REGISTRATION + "("
    			+ KEY_ID + " INTEGER PRIMARY KEY,"
    			+ KEY_NAME + " TEXT NOT NULL,"
    			+ KEY_EMAIL + " TEXT NOT NULL,"
    			+ KEY_PASSWORD + " TEXT" + ")";
    	db.execSQL(CREATE_REGISTRATION_TABLE);
    	
    	// Creating the Login Table
    	String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_LOGIN + "("
    			+ KEY_ID + " INTEGER PRIMARY KEY,"
    			+ KEY_EMAIL + " TEXT NOT NULL,"
    			+ KEY_PASSWORD + " TEXT NOT NULL" + ")";
    	db.execSQL(CREATE_LOGIN_TABLE);
    	
    	// Creating the Contacts Table
    	String CREATE_CONTACTS_TABLE = "CREAT TABLE " + TABLE_CONTACTS + "("
    			+ KEY_ID + " INTEGER PRIMARY KEY,"
    			+ KEY_NAME + " TEXT NOT NULL,"
    			+ KEY_EMAIL + " TEXT NOT NULL" + ")";
    	db.execSQL(CREATE_CONTACTS_TABLE);    	
    }
    
    // Upgrading Database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	// Drop older table if existed
    	db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTRATION
    			+ " AND " + TABLE_LOGIN + " AND " + TABLE_CONTACTS);
    	// Create tables again
    	onCreate(db);
    }
    
    // Adding new contact
    public void addContact(Users contact) {
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	ContentValues values = new ContentValues();
    	values.put(KEY_NAME, contact.getName()); // Contact name
    	values.put(KEY_EMAIL, contact.getEmail()); // Contact email
    	
    	// Inserting row
    	db.insert(TABLE_CONTACTS, null, values);
    	db.close(); // Closing database connection
    }
    
    // Getting single contact
    public Users getContact(int id) {
    	SQLiteDatabase db = this.getReadableDatabase();
    	
    	Cursor cursor = db.query(TABLE_CONTACTS, new String[] {KEY_ID, KEY_NAME, KEY_EMAIL}, KEY_ID + "=?", 
    											new String[] {String.valueOf(id)}, null, null, null, null);
    	if (cursor != null) {
    		cursor.moveToFirst();
    	}
    	
    	Users contact = new Users(Integer.parseInt(cursor.getString(0)),
    					cursor.getString(1), cursor.getString(2));
    	
    	// Return contact
    	return contact;
    }
    
    // Getting all contacts
    public List<Users> getAllContacts() {
    	List<Users> contactList = new ArrayList<Users>();
    	// Select All query
    	String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;
    	
    	SQLiteDatabase db = this.getWritableDatabase();
    	Cursor cursor = db.rawQuery(selectQuery, null);
    	
    	// Looping through all rows and adding to list
    	if (cursor.moveToFirst()) {
    		do {
    			Users contact = new Users();
    			contact.setId(Integer.parseInt(cursor.getString(0)));
    			contact.setName(cursor.getString(1));
    			contact.setEmail(cursor.getString(2));
    			// Adding contact to list
    			contactList.add(contact);
    		}
    		while (cursor.moveToNext());
    	}
    	// Return contact list
    	return contactList;
    }
    
    // Updating single contact
    public int updateContact(Users contact) {
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	ContentValues values = new ContentValues();
    	values.put(KEY_NAME, contact.getName());
    	values.put(KEY_EMAIL, contact.getEmail());
    	
    	// Updating row
    	return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?", 
    			new String[] {String.valueOf(contact.getId())});
    }    
    
    // Deleting single contact
    public void deleteContact(Users contact) {
    	SQLiteDatabase db = this.getWritableDatabase();
    	db.delete(TABLE_CONTACTS, KEY_ID + " = ?", 
    			new String[] {String.valueOf(contact.getId())});
    	db.close();
    }
    
    // Getting contacts count
    public int getContactsCount() {
    	String countQuery = "SELECT * FROM " + TABLE_CONTACTS;
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor cursor = db.rawQuery(countQuery, null);
    	cursor.close();
    	
    	// Return count
    	return cursor.getCount();
    }


	
}
