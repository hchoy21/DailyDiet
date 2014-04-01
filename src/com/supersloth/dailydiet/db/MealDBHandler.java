package com.supersloth.dailydiet.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MealDBHandler extends SQLiteOpenHelper{

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "mealManager";
	private static final String TABLE_MEALS = "meals";
	
	//column names
	private static final String KEY_NAME = "name";
	private static final String KEY_PROTEIN = "protein";
	private static final String KEY_VEG = "veg";
	private static final String KEY_CARB = "carb";
	
	
	public MealDBHandler(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}


	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		String CREATE_MEALS_TABLE = "CREATE TABLE" + TABLE_MEALS
				+ "(" + KEY_NAME + " STRING PRIMARY KEY,"
				+ KEY_PROTEIN + " TEXT," + KEY_VEG + " TEXT,"
				+ KEY_CARB + " TEXT" + ")";
		arg0.execSQL(CREATE_MEALS_TABLE);
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEALS);
		
		onCreate(db);
	}
	
	/********************************************************
	 *  CREATE, READ, UPDATE, DELETE
	 ********************************************************/
	
	public Meal getMeal(String name){
		SQLiteDatabase db = this.getReadableDatabase();
		 
        Cursor cursor = db.query(TABLE_MEALS,		// table name
        		new String[] { KEY_NAME,			// columns
                	KEY_PROTEIN, KEY_VEG, KEY_CARB }, 
                KEY_NAME + "=?",					// selection
                new String[] { name },				// selectionArgs
                null, 
                null, 
                null, 
                null);
        if (cursor != null)
            cursor.moveToFirst();
 
        Meal meal = new Meal(cursor.getString(0),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
		return meal;
	}
	
	public Meal getChickenMeals(){
		SQLiteDatabase db = this.getReadableDatabase();

		// select KEY_NAME from TABLE_MEALS where KEY_PROTEIN having chicken
		
		Meal meal = new Meal();
		
		return meal;
	}
	
	
}
