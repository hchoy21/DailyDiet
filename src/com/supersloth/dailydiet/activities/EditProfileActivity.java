package com.supersloth.dailydiet.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.supersloth.dailydiet.R;

public class EditProfileActivity extends Activity {

	private Button updateProfile, back;
	private EditText etProfileName, etUserAge, etUserHeight, etBeginWeight, etEndWeight;
	String userName;
	int userAge, userHeight, userWeight, userGoal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_profile);

		// separate method to assign all variables
		setupVariables();
		
		
		updateProfile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				savePref();

			}
		});
		
	}
	
	
	private void savePref(){
		userName = etProfileName.getText().toString();
		userAge = Integer.parseInt(etUserAge.getText().toString());
		userHeight = Integer.parseInt(etUserHeight.getText().toString());
		userWeight = Integer.parseInt(etBeginWeight.getText().toString());
		userGoal = Integer.parseInt(etEndWeight.getText().toString());
		
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(this);

		Editor editor = sharedPreferences.edit();

		editor.putString("userName", userName);
		editor.putInt("userAge", userAge);
		editor.putInt("userHeight", userHeight);
		editor.putInt("userGoal", userGoal);
//		editor.putInt(userProgress, progress);

		editor.commit();
		
		updateProfileButton();
	}


	private void setupVariables() {

		updateProfile = (Button) findViewById(R.id.bUpdateProfile);
		back = (Button)findViewById(R.id.bBacktoProfile);
		etProfileName = (EditText) findViewById(R.id.etName);
		etUserAge = (EditText) findViewById(R.id.etAge);
		etUserHeight = (EditText) findViewById(R.id.etHeight);
		etBeginWeight = (EditText) findViewById(R.id.etStartWeight);
		etEndWeight = (EditText) findViewById(R.id.etGoalWeight);

	}

	// Connect Buttons to action
	public void updateProfileButton() {
		Intent intent = new Intent(this, ProfileActivity.class);
		startActivity(intent);
	}
}