package edu.psu.ktwok.pocketplayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class UsersDataSource {
	// Database Fields
	private SQLiteDatabase database;
	private DatabaseHandler dbHandler;
	private String[] regColumns = 		{ 	PocketPlayerDBContract.TblRegister.COLUMN_NAME_GID, 
											PocketPlayerDBContract.TblRegister.COLUMN_NAME_USER,
											PocketPlayerDBContract.TblRegister.COLUMN_NAME_EMAIL,
											PocketPlayerDBContract.TblRegister.COLUMN_NAME_PASS 	};
	
	private String[] contactColumns = 	{	PocketPlayerDBContract.TblContacts.COLUMN_NAME_GID,
											PocketPlayerDBContract.TblContacts.COLUMN_NAME_USER,
											PocketPlayerDBContract.TblContacts.COLUMN_NAME_EMAIL 	};
	
	private String[] equipColumns = 	{ 	PocketPlayerDBContract.TblEquip.COLUMN_NAME_GID,
									  		PocketPlayerDBContract.TblEquip.COLUMN_NAME_PRIM,
									  		PocketPlayerDBContract.TblEquip.COLUMN_NAME_OFFHAND,
									  		PocketPlayerDBContract.TblEquip.COLUMN_NAME_ARMOR 		};
	
	private String[] skillColumns = 	{ 	PocketPlayerDBContract.TblSkill.COLUMN_NAME_GID,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_ACR,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_APR,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_BLU,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_CLI,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_DIP,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_DIS,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_HEA,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_LIN,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_PER,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_PRF,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_SEN,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_SOH,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_SPL,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_STL,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_SUR,
									  		PocketPlayerDBContract.TblSkill.COLUMN_NAME_SWM 		};
	
	private String[] statColumns = 		{	PocketPlayerDBContract.TblStat.COLUMN_NAME_GID,
											PocketPlayerDBContract.TblStat.COLUMN_NAME_PLN,
											PocketPlayerDBContract.TblStat.COLUMN_NAME_STR,
											PocketPlayerDBContract.TblStat.COLUMN_NAME_DEX,
											PocketPlayerDBContract.TblStat.COLUMN_NAME_CON,
											PocketPlayerDBContract.TblStat.COLUMN_NAME_INT,
											PocketPlayerDBContract.TblStat.COLUMN_NAME_WIS,
											PocketPlayerDBContract.TblStat.COLUMN_NAME_CHR			};

	public UsersDataSource(Context context) {
		dbHandler = new DatabaseHandler(context);
	}
	
	public void open() throws SQLException {
		database = dbHandler.getWritableDatabase();
	}
	
	public void close() {
		dbHandler.close();
	}
	
	public boolean register(String user, String email, String password) {
		ContentValues vals = new ContentValues();
		
		vals.put(PocketPlayerDBContract.TblRegister.COLUMN_NAME_USER, user);
		vals.put(PocketPlayerDBContract.TblRegister.COLUMN_NAME_EMAIL, email);
		vals.put(PocketPlayerDBContract.TblRegister.COLUMN_NAME_PASS, password);
		
		// Insert Registered Users to DB
		try {
			database.insertOrThrow(PocketPlayerDBContract.TblRegister.TABLE_NAME, null, vals);
			return true;
		}
		catch (SQLiteConstraintException e) {
			return false;
		}

		
	}
	
	public boolean login(String email, String password) throws SQLException {
		Cursor mCursor = database.rawQuery("SELECT * FROM " + PocketPlayerDBContract.TblRegister.TABLE_NAME + 
										   " WHERE email =? AND password =?", new String[] {email,password});
		if (mCursor != null) {
			if (mCursor.getCount() > 0) {
				return true;
			}
		}
		return false;
	}
}
