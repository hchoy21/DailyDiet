package com.supersloth.dailydiet.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
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
	
	
	/**
	 * queries the database and returns a list of all meals
	 * 
	 * @return List<Meal> all meals
	 */
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
				meal.set_carbs(cursor.getString(4));
				
				mealList.add(meal);
				
			}while(cursor.moveToNext());
		}
		
		
		return mealList;
	}
	
	public List<Meal> getMealsProtein(String protein){
		List<Meal> meals = new ArrayList<Meal>();
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.query(true, TABLE_MEALS, new String[] {
						KEY_ID,
						KEY_NAME,
						KEY_PROTEIN, 
						KEY_VEG,
						KEY_CARB
				}, 
				KEY_PROTEIN + "=?",
				new String[] {protein},
				null, 
				null, 
				null, 
				null);
		
		if(cursor.moveToFirst()){
			do{
				Meal meal = new Meal();
				meal.set_id(Integer.parseInt(cursor.getString(0)));
				meal.set_name(cursor.getString(1));
				meal.set_protein(cursor.getString(2));
				meal.set_veg(cursor.getString(3));
				meal.set_carbs(cursor.getString(4));
				
				meals.add(meal);

			}while(cursor.moveToNext());
		}
				
		return meals;
	}
	
	public List<Meal> getMealsVeg(String veg){
		List<Meal> meals = new ArrayList<Meal>();
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.query(true, TABLE_MEALS, new String[] {
						KEY_ID,
						KEY_NAME,
						KEY_PROTEIN, 
						KEY_VEG,
						KEY_CARB
				}, 
				KEY_PROTEIN + "=?",
				new String[] {veg},
				null, 
				null, 
				null, 
				null);
		
		if(cursor.moveToFirst()){
			do{
				Meal meal = new Meal();
				meal.set_id(Integer.parseInt(cursor.getString(0)));
				meal.set_name(cursor.getString(1));
				meal.set_protein(cursor.getString(2));
				meal.set_veg(cursor.getString(3));
				meal.set_carbs(cursor.getString(4));
				
				meals.add(meal);

			}while(cursor.moveToNext());
		} 
				
		return meals;
	}
	
	public List<Meal> getMealsCarb(String carb){
		List<Meal> meals = new ArrayList<Meal>();
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.query(true, TABLE_MEALS, new String[] {
						KEY_ID,
						KEY_NAME,
						KEY_PROTEIN, 
						KEY_VEG,
						KEY_CARB
				}, 
				KEY_PROTEIN + "=?",
				new String[] {carb},
				null, 
				null, 
				null, 
				null);
		
		if(cursor.moveToFirst()){
			do{
				Meal meal = new Meal();
				meal.set_id(Integer.parseInt(cursor.getString(0)));
				meal.set_name(cursor.getString(1));
				meal.set_protein(cursor.getString(2));
				meal.set_veg(cursor.getString(3));
				meal.set_carbs(cursor.getString(4));
				
				meals.add(meal);

			}while(cursor.moveToNext());
		}
				
		return meals;
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

	public List<Meal> getAvailableMeals(List<String> proteins,
			List<String> vegs, List<String> carbs) {

		if (proteins.size() == 0 || vegs.size() == 0 || carbs.size() == 0) {
			return null;
		}

		List<Meal> mealList = new ArrayList<Meal>();

		String proteinList, vegList, carbList;

		proteinList = "'" + proteins.get(0) + "'";
		vegList = "'" + vegs.get(0) + "'";
		carbList = "'" + carbs.get(0) + "'";

		if (proteins.size() != 1) {
			for (String protein : proteins) {
				proteinList += ", '" + protein + "'";
			}
		}
		if (vegs.size() != 1) {
			for (String veg : vegs) {
				vegList += ", '" + veg + "'";
			}
		}
		if (carbs.size() != 1) {
			for (String carb : carbs) {
				carbList += ", '" + carb + "'";
			}
		}

		// select query
		String select = "SELECT * FROM " + TABLE_MEALS + " WHERE ("
				+ KEY_PROTEIN + " in (" + proteinList + ") AND " + KEY_VEG
				+ " in (" + vegList + ") AND " + KEY_CARB + " in (" + carbList
				+ "))";

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(select, null);

		// loop through all rows and add to list
		if (cursor.moveToFirst()) {
			do {
				Meal meal = new Meal();
				meal.set_id(Integer.parseInt(cursor.getString(0)));
				meal.set_name(cursor.getString(1));
				meal.set_protein(cursor.getString(2));
				meal.set_veg(cursor.getString(3));
				meal.set_carbs(cursor.getString(4));

				mealList.add(meal);

			} while (cursor.moveToNext());
		}

		return mealList;
	}

	
	
}
