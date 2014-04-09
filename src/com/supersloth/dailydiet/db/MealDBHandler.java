package com.supersloth.dailydiet.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MealDBHandler extends SQLiteOpenHelper{

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "mealManager";
	private static final String TABLE_MEALS = "meals";
	
	//column names
	private static final String	KEY_ID = "id";
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
		String CREATE_MEALS_TABLE = "CREATE TABLE " + TABLE_MEALS
				+ " (" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT,"
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
	
	public Meal getMealFromId(int id){
		SQLiteDatabase db = this.getReadableDatabase();
		 
		Cursor cursor = db.query(TABLE_MEALS, new String[] { KEY_ID,
	            KEY_NAME, KEY_PROTEIN, KEY_VEG, KEY_CARB }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
	    if (cursor != null)
	        cursor.moveToFirst();
 
        Meal meal = new Meal(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), 
                cursor.getString(3), cursor.getString(4));
		return meal;
	}
	
//	public Meal getChickenMeals(){
//		SQLiteDatabase db = this.getReadableDatabase();
//
//		// select KEY_NAME from TABLE_MEALS where KEY_PROTEIN having chicken
//	}
	
	public List<Meal> getAllMeals(){
		List<Meal> mealList = new ArrayList<Meal>();
		
		// select query
		String select = "SELECT * FROM " + TABLE_MEALS;
		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(select, null);
		
		// loop through all rows and add to list
		if(cursor.moveToFirst()){
			do{
				Meal meal = new Meal();
				meal.set_id(Integer.parseInt(cursor.getString(0)));
				meal.set_name(cursor.getString(1));
				meal.set_protein(cursor.getString(2));
				meal.set_veg(cursor.getString(3));
				meal.set_carbs(cursor.getColumnName(4));
				
				mealList.add(meal);
				
			}while(cursor.moveToNext());
		}
		
		
		return mealList;
	}
	
	public void addMeal(Meal meal){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_ID, meal.get_id());
		values.put(KEY_NAME, meal.get_name());
		values.put(KEY_PROTEIN, meal.get_protein());
		values.put(KEY_VEG, meal.get_veg());
		values.put(KEY_CARB, meal.get_carbs());
		
		db.insert(TABLE_MEALS, null, values);
		db.close();
	}
	
	
}
