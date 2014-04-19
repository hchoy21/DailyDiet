package com.supersloth.dailydiet.activities;

import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.supersloth.dailydiet.R;
import com.supersloth.dailydiet.db.Meal;
import com.supersloth.dailydiet.db.MealDBHandler;

public class MainActivity extends Activity{

	private static final String TAG = "MainActivity";
	public List<Meal> mealsList, chickenMeals;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button bGroceryList = (Button) findViewById(R.id.bGroceryList);
		Button bProfile = (Button) findViewById(R.id.bProfile);
		Button bHealthyTips = (Button) findViewById(R.id.bHealthyTips);
		Button bHungry = (Button) findViewById(R.id.bHungry);
		
		
		// set the date at the top of activity
		TextView date = (TextView) findViewById(R.id.tvTodaysDate);
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		int year = c.get(Calendar.YEAR);
		String todaysDate = month+"/"+day+"/"+year;
		date.setText(todaysDate);
		
		// go to grocery list activity
		bGroceryList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "Grocery list button clicked");
				groceryListButton();}});
		
		// go to profile activity
		bProfile.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Log.d(TAG, "Profile button clicked");
				profileButton();}});
		
		// go to favorite dish activity
		bHealthyTips.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "Healthy tips button clicked");
				healthyTipsButton();}});
		
		// go to hungry activity
		bHungry.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "I'm Hungry button clicked");
				hungryButton();}});
		
		
		// create db
		MealDBHandler db = new MealDBHandler(this);
		
		// insert meals
		Log.d("Insert: ", "Inserting ..");
		db.addMeal(new Meal(1, "Spaghetti and Meatballs", "beef", null, "pasta"));
		db.addMeal(new Meal(2, "Chicken Fried Rice", "chicken", "carrot", "rice"));
		db.addMeal(new Meal(3, "Black and White Sesame Chicken", "chicken", "tomato", null));
		db.addMeal(new Meal(4, "Grilled Salmon", "fish", "lettuce", null));
		db.addMeal(new Meal(5, "Chik Fil A Sandwich", "chicken", "pickle", "bread"));
		mealsList = db.getAllMeals();
		
		chickenMeals = db.getMealsProtein("chicken");
		
//		for(Meal m : mealsList){
//			String log = "Id: " + m.get_id() + ", Name: " + m.get_name()
//					+ ", Meat: " + m.get_protein() + ", Vegetable: " + m.get_veg()
//					+ ", Carb: " + m.get_carbs();
//			Log.d("Name: ", log);
//		}
		
		for(Meal m : chickenMeals){
			String log = "Id: " + m.get_id() + ", Name: " + m.get_name()
					+ ", Meat: " + m.get_protein() + ", Vegetable: " + m.get_veg()
					+ ", Carb: " + m.get_carbs();
			Log.d("Database Items(Chicken): ", log);
		}
	
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Button Methods
	public void profileButton(){
		Intent intent = new Intent(this, ProfileActivity.class);
		startActivity(intent);
	}
	
	public void hungryButton(){
		Intent intent = new Intent(this, HungryActivity.class);
		startActivity(intent);
	}

	public void healthyTipsButton(){
		Intent intent = new Intent(this, HealthyTipsActivity.class);
		startActivity(intent);
	}
	
	public void groceryListButton(){
		Intent intent = new Intent(this, GroceryListActivity.class);
		startActivity(intent);
	}
	
}
