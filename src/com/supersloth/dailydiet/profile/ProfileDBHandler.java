package com.supersloth.dailydiet.profile;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * DB and handler for profiles
 * @author Hendrik Choy
 *
 */
public class ProfileDBHandler extends SQLiteOpenHelper{
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "profileManager";
	private static final String TABLE_PROFILES = "profiles";
	
	//column names
	private static final String KEY_ID = "id";
	private static final String KEY_FIRST = "first";
	private static final String KEY_LAST = "last";
	
	public ProfileDBHandler(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		String CREATE_PROFILES_TABLE = "CREATE TABLE" + TABLE_PROFILES
				+ "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FIRST
				+ " TEXT," + KEY_LAST + " TEXT" + ")";
		
		arg0.execSQL(CREATE_PROFILES_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILES);
		
		onCreate(arg0);
	}
	
	
	/***************************************************************
	 * CREATE/READ/UPDATE/DELETE OPERATIONS
	 ***************************************************************/

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
