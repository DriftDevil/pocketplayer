package edu.psu.ktwok.pocketplayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

// Singleton class
public class PocketPlayerDB {

	private static PocketPlayerDB thePocketPlayerDB;
	private SQLiteDatabase theDb;
	private boolean isReady;
	
	private PocketPlayerDB() { }
	
	public static PocketPlayerDB getInstance(Context context) {
		
		if (thePocketPlayerDB == null) {		
			thePocketPlayerDB = new PocketPlayerDB();
			thePocketPlayerDB.isReady = false;
			
			// Open DB in an AsyncTask, since it may take a while
			thePocketPlayerDB.new OpenDbAsyncTask().execute(context);
		}
		return thePocketPlayerDB;
	}
	
	public boolean initialized() { return isReady; }
	
    private class OpenDbAsyncTask extends AsyncTask<Context, Void, Void> {
  
		@Override
		protected Void doInBackground(Context... params) {
			DatabaseHandler theDBHandler = new DatabaseHandler(params[0]);
			theDb = theDBHandler.getWritableDatabase();
			isReady = true;
			return null;
		}
  
    }
    
    public SQLiteDatabase getDB() {
    	if (isReady == false) return null;
    	return theDb;
    }
}
