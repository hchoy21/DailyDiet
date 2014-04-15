package com.supersloth.dailydiet.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.supersloth.dailydiet.R;

public class ProfileActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		Button editProfile = (Button) findViewById(R.id.bEditProfile);
		Button updateWeight = (Button) findViewById(R.id.bUpdateWeight);
		
		// Set Button Functions
		editProfile.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				editProfileButton();
			}
		});
		
		updateWeight.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateWeightButton();
			}
		});
		
	}
	
	
	// Connect Buttons to action
	public void editProfileButton() {
		Intent intent = new Intent(this, EditProfileActivity.class);
		startActivity(intent);
	}
	
	public void updateWeightButton() {
		Intent intent = new Intent(this, ProgressActivity.class);
		startActivity(intent);
	}
	
}
