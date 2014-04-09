package com.supersloth.dailydiet.activities;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.supersloth.dailydiet.db.Meal;
import com.supersloth.dailydiet.db.MealDBHandler;

public class InsertMealsActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		MealDBHandler db = new MealDBHandler(this);
		

		// insert meals
		Log.d("Insert: ", "Inserting ..");
		db.addMeal(new Meal("Spaghetti and Meatballs", "beef", null, "pasta"));
		db.addMeal(new Meal("Chicken Fried Rice", "chicken", "carrot", "rice"));
		db.addMeal(new Meal("Black and White Sesame Chicken", "chicken", "tomato", null));
		db.addMeal(new Meal("Grilled Salmon", "fish", "lettuce", null));
	}
	
	

}
