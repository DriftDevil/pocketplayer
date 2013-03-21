package edu.psu.ktwok.pocketplayer;

import android.content.Context;
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
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    
    public DatabaseHandler(Context context) {
    	super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    // Create Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
    	
    	// TODO: set primary keys //
    	
    	// Creating the Registration Table
    	String CREATE_REGISTRATION_TABLE = "CREATE TABLE " + TABLE_REGISTRATION + "("
    			+ KEY_NAME + " TEXT,"
    			+ KEY_EMAIL + " TEXT,"
    			+ KEY_PASSWORD + " TEXT" + ")";
    	db.execSQL(CREATE_REGISTRATION_TABLE);
    	
    	// Creating the Login Table
    	String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_LOGIN + "("
    			+ KEY_EMAIL + " TEXT,"
    			+ KEY_PASSWORD + " TEXT" + ")";
    	db.execSQL(CREATE_LOGIN_TABLE);
    	
    	
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
	
}
