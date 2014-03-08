package com.supersloth.dailydiet.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.supersloth.dailydiet.R;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button bGroceryList = (Button) findViewById(R.id.bGroceryList);
		Button bProfile = (Button) findViewById(R.id.bProfile);
		
		
		// go to grocery list activity
		bGroceryList.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				groceryListButton();
			}
		});
		
		// go to profile activity
		bProfile.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				profileButton();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void profileButton(){
		Intent intent = new Intent(this, ProfileActivity.class);
		startActivity(intent);
	}
	
	public void hungryButton(){
		
	}

	public void favoriteDishesButton(){
		
	}
	
	public void groceryListButton(){
		Intent intent = new Intent(this, GroceryListActivity.class);
		startActivity(intent);
	}
	
}
