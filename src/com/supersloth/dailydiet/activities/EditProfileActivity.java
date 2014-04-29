package com.supersloth.dailydiet.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.supersloth.dailydiet.R;

public class EditProfileActivity extends Activity {

	// create a file to save SharedPreferences in
	public static final String PREFS_NAME = "MyPreferencesFile";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_profile);
		
		getActionBar().setHomeButtonEnabled(true);

		// initialize edit texts and button
		final EditText name = (EditText) findViewById(R.id.etName);
		final EditText age = (EditText) findViewById(R.id.etAge);
		final EditText height = (EditText) findViewById(R.id.etHeight);
		final EditText weight = (EditText) findViewById(R.id.etWeight);
		final EditText goal = (EditText) findViewById(R.id.etGoal);
		final EditText progress = (EditText) findViewById(R.id.etProgress);

		Button save = (Button) findViewById(R.id.bSaveProfile);

		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0); 
		name.setText(settings.getString("name", "Super Sloth")); 
        age.setText(String.valueOf(settings.getInt("age", 21))); 
        height.setText(String.valueOf(settings.getInt("height", 68))); 
        weight.setText(String.valueOf(settings.getInt("weight", 175))); 
        goal.setText(String.valueOf(settings.getInt("goal", 150))); 
        progress.setText(String.valueOf(settings.getInt("progress", 160))); 
		
		
		// when button is clicked
		save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// call sharedPreferences
				SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

				// call SharedPreferences editor
				SharedPreferences.Editor editor = settings.edit();
				
				
				/** CRASH BELOW **/
				if(name == null || age == null || height == null
						|| weight == null || goal == null || progress == null){
					
					Toast toast = Toast.makeText(getApplicationContext(), "Please fill in all fields before proceeding", Toast.LENGTH_SHORT);
					toast.show();
				}
				else if (name != null && age != null && height != null
						&& weight != null && goal != null && progress != null) {
					// put editText values into SharedPreferences file
					editor.putString("name", name.getText().toString());
					editor.putInt("age",
							Integer.parseInt(age.getText().toString()));
					editor.putInt("height",
							Integer.parseInt(height.getText().toString()));
					editor.putInt("weight",
							Integer.parseInt(weight.getText().toString()));
					editor.putInt("goal",
							Integer.parseInt(goal.getText().toString()));
					editor.putInt("progress",
							Integer.parseInt(progress.getText().toString()));

					// commit information to SharedPreferences
					editor.commit();

					// let the user know the the profile has been saved
					String msg = "Profile Saved!";
					Toast.makeText(getApplicationContext(), msg,
							Toast.LENGTH_LONG).show();

					// create an intent to send SharedPreferences to next
					// activity
					// and call next activity
					Intent intent = new Intent(getApplicationContext(),
							ProfileActivity.class);
					startActivity(intent);
				}
				/** CRASH ABOVE **/
			}
		});

	}

	private void backButton() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		if (android.R.id.home == item.getItemId()) {
			backButton();
		}
		return super.onOptionsItemSelected(item);
	}
}