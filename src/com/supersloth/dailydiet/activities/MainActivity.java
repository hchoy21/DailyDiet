package com.supersloth.dailydiet.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.supersloth.dailydiet.R;

public class MainActivity extends Activity{

	private static final String TAG = "MainActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button bGroceryList = (Button) findViewById(R.id.bGroceryList);
		Button bProfile = (Button) findViewById(R.id.bProfile);
		Button bFavoriteDish = (Button) findViewById(R.id.bFavoriteDish);
		Button bHungry = (Button) findViewById(R.id.bHungry);
		
		// go to grocery list activity
		bGroceryList.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(TAG, "Grocery list button clicked");
				groceryListButton();
			}
		});
		
		// go to profile activity
		bProfile.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				Log.d(TAG, "Profile button clicked");
				profileButton();
			}
		});
		
		// go to favorite dish activity
		bFavoriteDish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d(TAG, "Favorite dish button clicked");
				favoriteDishesButton();
			}
		});
		
		// go to hungry activity
		bHungry.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d(TAG, "I'm Hungry button clicked");
				hungryButton();
			}
		});
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

	public void favoriteDishesButton(){
		Intent intent = new Intent(this, FavoriteDishActivity.class);
		startActivity(intent);
	}
	
	public void groceryListButton(){
		Intent intent = new Intent(this, GroceryListActivity.class);
		startActivity(intent);
	}
	
}
