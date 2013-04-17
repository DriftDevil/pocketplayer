package edu.psu.ktwok.pocketplayer;

import edu.psu.ktwok.pocketplayer.PocketPlayerDBContract;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	// Database Version Number
	private static final int DATABASE_VERSION = 4;
	// Database Name
	private static final String DATABASE_NAME = "usersManager";
	
	// Registration Table
	private static final String SQL_REG_ENTIRES =
			"CREATE TABLE " + PocketPlayerDBContract.TblRegister.TABLE_NAME + " (" +
					PocketPlayerDBContract.TblRegister.COLUMN_NAME_GID + " " +
					PocketPlayerDBContract.TblRegister.COLUMN_TYPE_GID + " PRIMARY KEY AUTOINCREMENT," +
					PocketPlayerDBContract.TblRegister.COLUMN_NAME_USER + " " +
					PocketPlayerDBContract.TblRegister.COLUMN_TYPE_USER + "," +
					PocketPlayerDBContract.TblRegister.COLUMN_NAME_EMAIL + " " +
					PocketPlayerDBContract.TblRegister.COLUMN_TYPE_EMAIL + "," +
					PocketPlayerDBContract.TblRegister.COLUMN_NAME_PASS + " " +
					PocketPlayerDBContract.TblRegister.COLUMN_TYPE_PASS + " )";
	// Delete Registration
	private static final String SQL_DELETE_REG_ENTRIES =
    	    "DROP TABLE IF EXISTS " +  PocketPlayerDBContract.TblRegister.TABLE_NAME;
	
	// Contacts Table
	private static final String SQL_CON_ENTRIES =
			"CREATE TABLE " + PocketPlayerDBContract.TblContacts.TABLE_NAME + " (" +
					PocketPlayerDBContract.TblContacts.COLUMN_NAME_GID + " " +
					PocketPlayerDBContract.TblContacts.COLUMN_TYPE_GID + " PRIMARY KEY," +
					PocketPlayerDBContract.TblContacts.COLUMN_NAME_EMAIL + " " +
					PocketPlayerDBContract.TblContacts.COLUMN_TYPE_EMAIL + "," +
					PocketPlayerDBContract.TblContacts.COLUMN_NAME_USER + " " +
					PocketPlayerDBContract.TblContacts.COLUMN_TYPE_USER + " )";
	// Delete Contacts
	private static final String SQL_DELETE_CON_ENTRIES =
    	    "DROP TABLE IF EXISTS " +  PocketPlayerDBContract.TblContacts.TABLE_NAME;
	
	// Stat Table Name
	private static final String SQL_STAT_ENTRIES =
			"CREATE TABLE " + PocketPlayerDBContract.TblStat.TABLE_NAME + " (" +
					PocketPlayerDBContract.TblStat.COLUMN_NAME_GID + " " +
					PocketPlayerDBContract.TblStat.COLUMN_TYPE_GID + " PRIMARY KEY," +
					
					PocketPlayerDBContract.TblStat.COLUMN_NAME_PLN + " " +
					PocketPlayerDBContract.TblStat.COLUMN_TYPE_PLN + "," +
					
					PocketPlayerDBContract.TblStat.COLUMN_NAME_STR + " " +
					PocketPlayerDBContract.TblStat.COLUMN_TYPE_STR + "," +
					
					PocketPlayerDBContract.TblStat.COLUMN_NAME_DEX + " " +
					PocketPlayerDBContract.TblStat.COLUMN_TYPE_DEX + "," +
					
					PocketPlayerDBContract.TblStat.COLUMN_NAME_CON + " " +
					PocketPlayerDBContract.TblStat.COLUMN_TYPE_CON + "," +
					
					PocketPlayerDBContract.TblStat.COLUMN_NAME_INT + " " +
					PocketPlayerDBContract.TblStat.COLUMN_TYPE_INT + "," +
					
					PocketPlayerDBContract.TblStat.COLUMN_NAME_WIS + " " +
					PocketPlayerDBContract.TblStat.COLUMN_TYPE_WIS + "," +
					
					PocketPlayerDBContract.TblStat.COLUMN_NAME_CHR + " " +
					PocketPlayerDBContract.TblStat.COLUMN_TYPE_CHR + " )";	
	// Delete Stats
	private static final String SQL_DELETE_STAT_ENTRIES =
    	    "DROP TABLE IF EXISTS " +  PocketPlayerDBContract.TblStat.TABLE_NAME;
	
	// Skill Table Name
	private static final String SQL_SKILL_ENTRIES =
			"CREATE TABLE " + PocketPlayerDBContract.TblSkill.TABLE_NAME + " (" +
					PocketPlayerDBContract.TblSkill.COLUMN_NAME_GID + " " +
					PocketPlayerDBContract.TblSkill.COLUMN_TYPE_GID + " PRIMARY KEY," +
			
					PocketPlayerDBContract.TblSkill.COLUMN_NAME_ACR + " " +
					PocketPlayerDBContract.TblSkill.COLUMN_TYPE_ACR + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_APR + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPR_APR + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_BLU + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_BLU + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_CLI + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_CLI + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_DIP + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_DIP + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_DIS + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_DIS + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_HEA + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_HEA + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_LIN + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_LIN + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_PER + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_PER + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_PRF + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_PRF + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_SEN + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_SEN + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_SOH + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_SOH + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_SPL + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_SPL + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_STL + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_STL + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_SUR + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_SUR + "," +
			        PocketPlayerDBContract.TblSkill.COLUMN_NAME_SWM + " " +
			        PocketPlayerDBContract.TblSkill.COLUMN_TYPE_SWM + " )";
	// Delete Skills
	private static final String SQL_DELETE_SKILL_ENTRIES =
    	    "DROP TABLE IF EXISTS " +  PocketPlayerDBContract.TblSkill.TABLE_NAME;
	
	// Equip Table Name
	private static final String SQL_EQUIP_ENTRIES =
			"CREATE TABLE " + PocketPlayerDBContract.TblEquip.TABLE_NAME + " (" +
					PocketPlayerDBContract.TblEquip.COLUMN_NAME_GID + " " +
					PocketPlayerDBContract.TblEquip.COLUMN_TYPE_GID + " PRIMARY KEY," +
					PocketPlayerDBContract.TblEquip.COLUMN_NAME_PRIM + " " +
					PocketPlayerDBContract.TblEquip.COLUMN_TYPE_PRIM + "," +
					PocketPlayerDBContract.TblEquip.COLUMN_NAME_OFFHAND + " " +
					PocketPlayerDBContract.TblEquip.COLUMN_TYPE_OFFHAND + "," +
					PocketPlayerDBContract.TblEquip.COLUMN_NAME_ARMOR + " " +
					PocketPlayerDBContract.TblEquip.COLUMN_TYPE_ARMOR + " )";
	// Delete Equipment
	private static final String SQL_DELETE_EQUIP_ENTRIES =
    	    "DROP TABLE IF EXISTS " +  PocketPlayerDBContract.TblEquip.TABLE_NAME;
	
    private Context context;
    
    public DatabaseHandler(Context context) {
    	super(context, DATABASE_NAME, null, DATABASE_VERSION);
    	this.context = context;
    }
    
    public void onCreate(SQLiteDatabase db){
    	db.execSQL(SQL_REG_ENTIRES);
    	db.execSQL(SQL_CON_ENTRIES);
    	db.execSQL(SQL_STAT_ENTRIES);
    	db.execSQL(SQL_EQUIP_ENTRIES);
    	db.execSQL(SQL_SKILL_ENTRIES);
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_DELETE_CON_ENTRIES);
		db.execSQL(SQL_DELETE_EQUIP_ENTRIES);
		db.execSQL(SQL_DELETE_REG_ENTRIES);
		db.execSQL(SQL_DELETE_SKILL_ENTRIES);
		db.execSQL(SQL_DELETE_STAT_ENTRIES);
		onCreate(db);
	}
	
	@Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, 
            int newVersion) {
    	onUpgrade(db, oldVersion, newVersion);
    }
}
