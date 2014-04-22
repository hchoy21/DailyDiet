package com.supersloth.dailydiet.activities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.supersloth.dailydiet.R;
import com.supersloth.dailydiet.db.Meal;
import com.supersloth.dailydiet.db.MealDBHandler;

public class MainActivity extends Activity{

	private static final String TAG = "MainActivity";
	public List<Meal> mealsList, chickenMeals, breadMeals;
	List<String> listProtein = new ArrayList<String>();
	List<String> listVeg = new ArrayList<String>();
	List<String> listCarb = new ArrayList<String>();
	List<Meal> possibleMeals;
	MealDBHandler db;
	
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
		
		
		
		
/****************************************** DATABASE ******************************************/
		db = new MealDBHandler(this);
		
		// insert meals
		Log.d("Insert: ", "Inserting ..");
		db.addMeal(new Meal(0, "Beef Stew", 				"beef", 	"bean", 	"potato"));
		db.addMeal(new Meal(1, "Beef Stroganoff", 			"beef",		"mushroom", "rice"));
		db.addMeal(new Meal(2, "Chicken Burrito", 			"chicken", 	"tomato", 	"tortilla"));
		db.addMeal(new Meal(3, "Chicken Penne", 			"chicken", 	"broccoli", "pasta"));
		db.addMeal(new Meal(4, "Chicken Teriyaki", 			"chicken", 	"broccoli", "rice"));
		db.addMeal(new Meal(5, "Fish Tacos", 				"fish", 	"lettuce", 	"tortilla"));
		db.addMeal(new Meal(6, "Pork Medallions", 			"pork", 	"mushroom", "bread"));
		db.addMeal(new Meal(7, "Salmon and Green Beans", 	"fish", 	"beans", 	"rice"));
		db.addMeal(new Meal(8, "Spaghetti and Meatballs",	"beef", 	"tomato", 	"pasta"));
		db.addMeal(new Meal(9, "Tuna Sandwich", 			"fish", 	"lettuce", 	"bread"));
		db.addMeal(new Meal(10, "Tuna Salad", 				"fish", 	"lettuce", 	"bread"));
		db.addMeal(new Meal(11, "Turkey Cutlets", 			"turkey", 	"bean", 	"bread"));
		db.addMeal(new Meal(12, "Turkey Sandwich", 			"turkey", 	"lettuce", 	"bread"));
		mealsList = db.getAllMeals();
		
		getSharedPref();
		
//		possibleMeals = db.getAvailableMeals(listProtein, listVeg, listCarb);
//		
//		Toast toast = Toast.makeText(getApplicationContext(), possibleMeals.size(), Toast.LENGTH_SHORT);
//		toast.show();
		
//		for(Meal m : possibleMeals){
//			Log.d("POSSIBLE MEALS: ", m.get_name());
//		}
	}

	
	
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
//		getSharedPref();
//
//		possibleMeals = db.getAvailableMeals(listProtein, listVeg, listCarb);
//
//		for (Meal m : possibleMeals) {
//			Log.d("POSSIBLE MEALS: ", m.get_name());
//		}
//		
//		Toast toast = Toast.makeText(getApplicationContext(), possibleMeals.size(), Toast.LENGTH_SHORT);
//		toast.show();

	}





	public void getSharedPref() {
		String ingred_protein[] = new String[5];
		String ingred_veg[] = new String[5];
		String ingred_carb[] = new String[5];
		

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);

		// save the SharedPreferences data
		ingred_protein[0] = sp.getBoolean("chicken", false) ? "chicken" : null;
		ingred_protein[1] = sp.getBoolean("beef", false) ? "beef" : null;
		ingred_protein[2] = sp.getBoolean("pork", false) ? "pork" : null;
		ingred_protein[3] = sp.getBoolean("fish", false) ? "fish" : null;
		ingred_protein[4] = sp.getBoolean("turkey", false) ? "turkey" : null;
		ingred_veg[0] = sp.getBoolean("mushroom", false) ? "mushroom" : null;
		ingred_veg[1] = sp.getBoolean("lettuce", false) ? "lettuce" : null;
		ingred_veg[2] = sp.getBoolean("broccoli", false) ? "broccoli" : null;
		ingred_veg[3] = sp.getBoolean("tomato", false) ? "tomato" : null;
		ingred_veg[4] = sp.getBoolean("bean", false) ? "bean" : null;
		ingred_carb[0] = sp.getBoolean("rice", false) ? "rice" : null;
		ingred_carb[1] = sp.getBoolean("bread", false) ? "bread" : null;
		ingred_carb[2] = sp.getBoolean("tortilla", false) ? "tortilla" : null;
		ingred_carb[3] = sp.getBoolean("potato", false) ? "potato" : null;
		ingred_carb[4] = sp.getBoolean("pasta", false) ? "pasta" : null;

		
		
		// separate and add user's groceries into the 3 categories
		for (int i = 0; i < ingred_protein.length; i++) {
			if (ingred_protein[i] != null)
				listProtein.add(ingred_protein[i]);
		}
		for (int i = 0; i < ingred_veg.length; i++) {
			if (ingred_veg[i] != null)
				listVeg.add(ingred_veg[i]);
		}
		for (int i = 0; i < ingred_carb.length; i++) {
			if (ingred_carb[i] != null)
				listCarb.add(ingred_carb[i]);
		}

		
		
		for (String m : listProtein)
			Log.d(TAG + "- Protein:", m + ", ");
		for (String m : listVeg)
			Log.d(TAG + "- Veg:", m + ", ");
		for (String m : listCarb)
			Log.d(TAG + "- Carb:", m + ", ");
	}
	
	
	
	
	
	
	
	
	
/****************************************** Button Methods ******************************************/
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
