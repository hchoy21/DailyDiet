package com.supersloth.dailydiet.activities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.supersloth.dailydiet.R;
import com.supersloth.dailydiet.db.Meal;
import com.supersloth.dailydiet.db.MealDBHandler;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	public static final String PREFS_NAME = "MyPreferencesFile"; 
	private String ingred_protein[] = new String[5];
	private String ingred_veg[] = new String[5];
	private String ingred_carb[] = new String[5];
	private List<String> listProtein = new ArrayList<String>();
	private List<String> listVeg = new ArrayList<String>();
	private List<String> listCarb = new ArrayList<String>();
	public List<Meal> mealsList, chickenMeals, breadMeals, meals;
	private MealDBHandler db;
	private ImageButton mImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button bGroceryList = (Button) findViewById(R.id.bGroceryList);
		Button bProfile = (Button) findViewById(R.id.bProfile);
		Button bHealthyTips = (Button) findViewById(R.id.bHealthyTips);
		Button bHungry = (Button) findViewById(R.id.bHungry);
		mImage = (ImageButton) findViewById(R.id.imageButton1);

		// set the date at the top of activity
		TextView date = (TextView) findViewById(R.id.tvTodaysDate);
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		int year = c.get(Calendar.YEAR);
		String todaysDate = month + "/" + day + "/" + year;
		date.setText(todaysDate);

		// go to grocery list activity
		bGroceryList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Log.d(TAG, "Grocery list button clicked");
				groceryListButton();
			}
		});

		// go to profile activity
		bProfile.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Log.d(TAG, "Profile button clicked");
				profileButton();
			}
		});

		// go to favorite dish activity
		bHealthyTips.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Log.d(TAG, "Healthy tips button clicked");
				healthyTipsButton();
			}
		});

		// go to hungry activity
		bHungry.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Log.d(TAG, "I'm Hungry button clicked");
				hungryButton();
			}
		});
		

		mImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(meals.size() > 0){
					imageMealButton();
				}else{
					mImage.setImageResource(R.drawable.recipebutton);
					Toast toast = Toast.makeText(getApplicationContext(), "No possible recipes", Toast.LENGTH_SHORT);
					toast.show();
				}
			}
		});

		/****************************************** DATABASE ******************************************/
		db = new MealDBHandler(this);

		// insert meals
		Log.d("Insert: ", "Inserting ..");
		db.addMeal(new Meal(1, "Beef Stew", "beef", "beans", "potato"));
		db.addMeal(new Meal(2, "Beef Stroganoff", "beef", "mushrooms", "rice"));
		db.addMeal(new Meal(3, "Chicken Burrito", "chicken", "tomato",
				"tortilla"));
		db.addMeal(new Meal(4, "Chicken Penne", "chicken", "broccoli", "pasta"));
		db.addMeal(new Meal(5, "Chicken Teriyaki", "chicken", "broccoli",
				"rice"));
		db.addMeal(new Meal(6, "Fish Tacos", "fish", "lettuce", "tortilla"));
		db.addMeal(new Meal(7, "Pork Medallions", "pork", "mushrooms", "bread"));
		db.addMeal(new Meal(8, "Salmon and Green Beans", "fish", "beans",
				"rice"));
		db.addMeal(new Meal(9, "Spaghetti and Meatballs", "beef", "tomato",
				"pasta"));
		db.addMeal(new Meal(10, "Tuna Sandwich", "fish", "lettuce", "bread"));
		db.addMeal(new Meal(11, "Tuna Salad", "fish", "lettuce", "bread"));
		db.addMeal(new Meal(12, "Turkey Cutlets", "turkey", "beans", "bread"));
		db.addMeal(new Meal(13, "Turkey Sandwich", "turkey", "lettuce", "bread"));
		mealsList = db.getAllMeals();

		/**
		 * Beef Stew "beef", "beans", "potato" Beef Stroganoff "beef",
		 * "mushrooms", "rice" Pork Medallions "pork", "mushrooms", "bread"
		 * Turkey Cutlets "turkey", "beans", "bread"
		 */

		// test
		// List<String> proteins = new ArrayList<String>();
		// proteins.add("beef");
		// proteins.add("chicken");
		// List<String> vegs = new ArrayList<String>();
		// vegs.add("mushrooms");
		// vegs.add("tomato");
		// List<String> carbs = new ArrayList<String>();
		// carbs.add("potato");
		// carbs.add("tortilla");
		// carbs.add("rice");

		savePref();
		
		chooseMeal();
		

		// for (String ameal : listCarb) {
		// Toast toast = Toast.makeText(getApplicationContext(),
		// ameal + "", Toast.LENGTH_SHORT);
		// toast.show();
		// }
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();

		listProtein.clear();
		listCarb.clear();
		listVeg.clear();

		savePref();
		chooseMeal();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();

		listProtein.clear();
		listCarb.clear();
		listVeg.clear();

		savePref();
		chooseMeal();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		listProtein.clear();
		listCarb.clear();
		listVeg.clear();
		
		savePref();
		
		chooseMeal();
	}

	public void chooseMeal(){
		
		if (db.getAvailableMeals(listProtein, listVeg, listCarb) != null) {

			meals = db.getAvailableMeals(listProtein, listVeg, listCarb);

//			for (Meal ameal : meals) {
//				Toast toast = Toast.makeText(getApplicationContext(),
//						ameal.get_name() + "", Toast.LENGTH_SHORT);
//				toast.show();
//			}

			if(meals.size()  <= 0){
				return;
			}
			
			Random rand = new Random();
			int random = rand.nextInt(meals.size());

			SharedPreferences sp = PreferenceManager
					.getDefaultSharedPreferences(this);
			Editor editor = sp.edit();

			String rName = meals.get(random).get_name();
			editor.putString("ChoosenMeal", rName);
			if (rName.equals("Chicken Burrito")) {
				mImage.setImageResource(R.drawable.chickenburrito);
			} else if (rName.equals("Chicken Penne")) {
				mImage.setImageResource(R.drawable.chickenpenne);
			} else if (rName.equals("Chicken Teriyaki")) {
				mImage.setImageResource(R.drawable.chickenteriyaki);
			} else if (rName.equals("Fish Tacos")) {
				mImage.setImageResource(R.drawable.fishtacos);
			} else if (rName.equals("Salmon and Green Beans")) {
				mImage.setImageResource(R.drawable.salmon);
			} else if (rName.equals("Spaghetti and Meatballs")) {
				mImage.setImageResource(R.drawable.spaghettiwithmeatballs);
			} else if (rName.equals("Tuna Sandwich")) {
				mImage.setImageResource(R.drawable.tunasandwich);
			} else if (rName.equals("Tuna Salad")) {
				mImage.setImageResource(R.drawable.tunasalad);
			} else if (rName.equals("Turkey Sandwich")) {
				mImage.setImageResource(R.drawable.turkeysandwich);
			}

			editor.commit();
		}
		
	}
	
	
	public void savePref() {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);

		// save the SharedPreferences data
		ingred_protein[0] = sp.getBoolean("chicken", false) ? "chicken" : null;
		ingred_protein[1] = sp.getBoolean("beef", false) ? "beef" : null;
		ingred_protein[2] = sp.getBoolean("pork", false) ? "pork" : null;
		ingred_protein[3] = sp.getBoolean("fish", false) ? "fish" : null;
		ingred_protein[4] = sp.getBoolean("turkey", false) ? "turkey" : null;
		ingred_veg[0] = sp.getBoolean("mushrooms", false) ? "mushrooms" : null;
		ingred_veg[1] = sp.getBoolean("lettuce", false) ? "lettuce" : null;
		ingred_veg[2] = sp.getBoolean("broccoli", false) ? "broccoli" : null;
		ingred_veg[3] = sp.getBoolean("tomato", false) ? "tomato" : null;
		ingred_veg[4] = sp.getBoolean("beans", false) ? "beans" : null;
		ingred_carb[0] = sp.getBoolean("rice", false) ? "rice" : null;
		ingred_carb[1] = sp.getBoolean("bread", false) ? "bread" : null;
		ingred_carb[2] = sp.getBoolean("tortilla", false) ? "tortilla" : null;
		ingred_carb[3] = sp.getBoolean("potato", false) ? "potato" : null;
		ingred_carb[4] = sp.getBoolean("pasta", false) ? "pasta" : null;

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
	}

	/****************************************** Button Methods ******************************************/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Button Methods
	public void profileButton() {
		Intent intent = new Intent(this, ProfileActivity.class);
		startActivity(intent);
	}

	public void hungryButton() {
		Intent intent = new Intent(this, HungryActivity.class);
		startActivity(intent);
	}

	public void healthyTipsButton() {
		Intent intent = new Intent(this, HealthyTipsActivity.class);
		startActivity(intent);
	}

	public void groceryListButton() {
		Intent intent = new Intent(this, GroceryListActivity.class);
		startActivity(intent);
	}
	
	public void imageMealButton(){
		Intent intent = new Intent(this, RecipeActivity.class);
		startActivity(intent);
	}

}