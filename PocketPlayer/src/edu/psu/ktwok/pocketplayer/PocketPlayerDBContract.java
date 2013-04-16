package edu.psu.ktwok.pocketplayer;

import android.provider.BaseColumns;

public class PocketPlayerDBContract {
	private PocketPlayerDBContract() {};
	
	public static abstract class TblEquip implements BaseColumns {
		public static final String TABLE_NAME = "equip";
		
		public static final String COLUMN_NAME_GID = "gamerId";
		public static final String COLUMN_TYPE_GID = "INTEGER";
		
		public static final String COLUMN_NAME_PRIM = "Prim";
		public static final String COLUMN_TYPE_PRIM = "TEXT";
		
		public static final String COLUMN_NAME_OFFHAND = "Offhand";
		public static final String COLUMN_TYPE_OFFHAND = "TEXT";
		
		public static final String COLUMN_NAME_ARMOR = "Armor";
		public static final String COLUMN_TYPE_ARMOR = "TEXT";
	}
	
	public static abstract class TblSkill implements BaseColumns {
		public static final String TABLE_NAME = "skill";
		
		public static final String COLUMN_NAME_GID = "gamerId";
		public static final String COLUMN_TYPE_GID = "INTEGER";
		
		public static final String COLUMN_NAME_ACR = "Acrobatics";
		public static final String COLUMN_TYPE_ACR = "INTEGER";
        public static final String COLUMN_NAME_APR = "Appraise";
        public static final String COLUMN_TYPR_APR = "INTEGER";
        public static final String COLUMN_NAME_BLU = "Bluff";
        public static final String COLUMN_TYPE_BLU = "INTEGER";
        public static final String COLUMN_NAME_CLI = "Climb";
        public static final String COLUMN_TYPE_CLI = "INTEGER";
        public static final String COLUMN_NAME_DIP = "Diplomacy";
        public static final String COLUMN_TYPE_DIP = "INTEGER";
        public static final String COLUMN_NAME_DIS = "Disguise";
        public static final String COLUMN_TYPE_DIS = "INTEGER";
        public static final String COLUMN_NAME_HEA = "Heal";
        public static final String COLUMN_TYPE_HEA = "INTEGER";
        public static final String COLUMN_NAME_LIN = "Linguistics";
        public static final String COLUMN_TYPE_LIN = "INTEGER";
        public static final String COLUMN_NAME_PER = "Perception";
        public static final String COLUMN_TYPE_PER = "INTEGER";
        public static final String COLUMN_NAME_PRF = "Perform";
        public static final String COLUMN_TYPE_PRF = "INTEGER";
        public static final String COLUMN_NAME_SEN = "SenseMotive";
        public static final String COLUMN_TYPE_SEN = "INTEGER";
        public static final String COLUMN_NAME_SOH = "SleightOfHand";
        public static final String COLUMN_TYPE_SOH = "INTEGER";
        public static final String COLUMN_NAME_SPL = "Spellcraft";
        public static final String COLUMN_TYPE_SPL = "INTEGER";
        public static final String COLUMN_NAME_STL = "Stealth";
        public static final String COLUMN_TYPE_STL = "INTEGER";
        public static final String COLUMN_NAME_SUR = "Survival";
        public static final String COLUMN_TYPE_SUR = "INTEGER";
        public static final String COLUMN_NAME_SWM = "Swim";
        public static final String COLUMN_TYPE_SWM = "INTEGER";
	}
	
	public static abstract class TblStat implements BaseColumns {
		public static final String TABLE_NAME = "stat";
		
		public static final String COLUMN_NAME_GID = "gamerId";
		public static final String COLUMN_TYPE_GID = "INTEGER";
		
		public static final String COLUMN_NAME_PLN = "chrName";
		public static final String COLUMN_TYPE_PLN = "TEXT";
		
		public static final String COLUMN_NAME_STR = "Strength";
		public static final String COLUMN_TYPE_STR = "INTEGER";
		
		public static final String COLUMN_NAME_DEX = "Dexterity" ;
		public static final String COLUMN_TYPE_DEX = "INTEGER";
		
		public static final String COLUMN_NAME_CON = "Constitution";
		public static final String COLUMN_TYPE_CON = "INTEGER";
		
		public static final String COLUMN_NAME_INT = "Intelligence";
		public static final String COLUMN_TYPE_INT = "INTEGER";
		
		public static final String COLUMN_NAME_WIS = "Wisdom";
		public static final String COLUMN_TYPE_WIS = "INTEGER";
		
		public static final String COLUMN_NAME_CHR = "Charisma";
		public static final String COLUMN_TYPE_CHR = "INTEGER";
		
	}
	
	public static abstract class TblLogin implements BaseColumns {
		public static final String TABLE_NAME = "login";
		
		public static final String COLUMN_NAME_EMAIL = "Email";
		public static final String COLUMN_TYPE_EMAIL = "TEXT";
		
		public static final String COLUMN_NAME_PASS = "Password";
		public static final String COLUMN_TYPE_PASS = "TEXT";
		
		public static final String COLUMN_NAME_GID = "gameID";
		public static final String COLUMN_TYPE_GID = "INTEGER";
	}
	
	public static abstract class TblRegister implements BaseColumns {
		public static final String TABLE_NAME = "register";
		
		public static final String COLUMN_NAME_GID = "gameID";
		public static final String COLUMN_TYPE_GID = "INTEGER";
		
		public static final String COLUMN_NAME_USER = "name";
		public static final String COLUMN_TYPE_USER = "TEXT";
		
		public static final String COLUMN_NAME_EMAIL = "Email";
		public static final String COLUMN_TYPE_EMAIL = "TEXT";
		
		public static final String COLUMN_NAME_PASS = "Password";
		public static final String COLUMN_TYPE_PASS = "TEXT";
	}
	
	public static abstract class TblContacts implements BaseColumns {
		public static final String TABLE_NAME = "contacts";
		
		public static final String COLUMN_NAME_GID = "gameID";
		public static final String COLUMN_TYPE_GID = "INTEGER";
		
		public static final String COLUMN_NAME_EMAIL = "Email";
		public static final String COLUMN_TYPE_EMAIL = "TEXT";
		
		public static final String COLUMN_NAME_PASS = "Password";
		public static final String COLUMN_TYPE_PASS = "TEXT";
		
		
	}
	
	
}
