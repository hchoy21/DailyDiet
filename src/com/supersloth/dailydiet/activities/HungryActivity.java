package com.supersloth.dailydiet.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.supersloth.dailydiet.R;

public class HungryActivity extends Activity{

	private String ingred_protein[] = new String[5];
	private String ingred_veg[] = new String[5];
	private String ingred_carb[] = new String[5];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hungry);
		
//		chickenTest();
		
		ingredientsTest();
		
		
			
	}	
	private void ingredientsTest(){
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		
		// save the SharedPreferences data
		ingred_protein[0] = sp.getBoolean("chicken", false) ? "chicken" : null;
		ingred_protein[1] = sp.getBoolean("beef", false) ? "beef" : null;
		ingred_protein[2] = sp.getBoolean("pork", false) ? "pork" : null;
		ingred_protein[3] = sp.getBoolean("fish", false) ? "fish" : null;
		ingred_protein[4] = sp.getBoolean("lamb", false) ? "lamb" : null;
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
		
		List<String> listProtein = new ArrayList<String>();
		for(int i = 0; i < ingred_protein.length; i++){
			if(ingred_protein[i] != null){
				listProtein.add(ingred_protein[i]);
			}
		}
		List<String> listVeg = new ArrayList<String>();
		for(int i = 0; i < ingred_veg.length; i++){
			if(ingred_veg[i] != null){
				listVeg.add(ingred_protein[i]);
			}
		}
		List<String> listCarb = new ArrayList<String>();
		for(int i = 0; i < ingred_carb.length; i++){
			if(ingred_carb[i] != null){
				listCarb.add(ingred_carb[i]);
			}
		}
		
		for(String m : listProtein){
			Log.d("meats: ", m);
		}
		for(String m : listVeg){
			Log.d("veg: ", m);
		}
		for(String m : listCarb){
			Log.d("carbs: ", m);
		}
	}
	
	private void chickenTest(){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

		boolean t;

		t=sharedPreferences.getBoolean("chicken", false);

		if(t){
			Toast.makeText(getApplicationContext(), "I have chicken!", Toast.LENGTH_SHORT).show();
		}
		else{
			Toast.makeText(getApplicationContext(), "No chicken for me :(", Toast.LENGTH_SHORT).show();
		}
	}
}
