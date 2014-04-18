package com.supersloth.dailydiet.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.supersloth.dailydiet.R;

public class HungryActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hungry);
		
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
